package com.hamitmizrak._08_week_socket.server;


/*
 * Chat servcer için "merkezi"  oda(room) yapısıdır.
 * Kimler online ?
 * Kişiye özel mesaj
 * Genel mesaj
 * Thread-safety(eşzamanlılık)
 * */

import com.hamitmizrak._08_week_socket.SpecialColor;
import com.hamitmizrak._08_week_socket.common.ChatProtocol;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ChatRoom {


    // FIELD
    private final Map<String, PrintWriter> clientsByNick = new ConcurrentHashMap<>();

    // NORMALIZE_NICK
    private String normalizeNick(String nick) {
        if (nick == null) {
            nick = "";
        }
        nick = nick.trim();

        if (nick.isBlank()) {
            nick = "Guest";
        }

        // Birden fazla whitespace!i  '_' ile birleştir
        nick = nick.replaceAll("\\s+", "_");

        // Uznuluğu sınırkla
        if (nick.length() > 16) {
            nick = nick.substring(0, 16);
        }

        // güvenli karakter seti(harf,sayı, _, -)
        nick = nick.replaceAll("[^A-Za-z0-9_\\-]", "");
        if (nick.isBlank()) {
            nick = "Guest";
        }
        return nick;
    }

    // BROAD_CAST_SYS
    // Sistem mesajını yayınlar (join/leave/hata)
    private void broadcastSys(String text) {
        String safe = ChatProtocol.sanitize(text);
        String line = "SYS " + safe;

        for (PrintWriter printWriter : clientsByNick.values()) {
            printWriter.println(line);
        }
    }  //end broadcastSys

    // JOIN
    public String join(String desiredNick, PrintWriter out) {
        String nick = normalizeNick(desiredNick);
        clientsByNick.put(nick, out);
        broadcastSys("* " + nick + " joined");
        return nick;
    } // end join

    // UNIQUE (NICK)
    private String makeUniqueNick(String base) {
        String nick = base;
        if (!clientsByNick.containsKey(nick)) {
            return nick;
        }

        for (int i = 2; i <= 9999; i++) {
            String newNick = base + i;
            if (!clientsByNick.containsKey(newNick)) {
                return newNick;
            }
        }

        // Çok fazla kullanıcı varsa isim çakışmasını engeller
        return base + UUID.randomUUID().toString().substring(0, 4);
    }

    // CHANGE_NICK
    public String changeNick(String oldNick, String desiredNick, PrintWriter out) {
        String newNick = normalizeNick(desiredNick);

        // Eski Nic'i map'ten lsitesinden çıkar
        PrintWriter printWriter = clientsByNick.remove(oldNick);
        if (printWriter == null) {
            // Oturum state'i beklenmedik durumda ise tekrar join gibi davrab
            return join(newNick, out);
        }

        // Yeni Nick'i benzersiz hale getirip map'e koyalım
        String uniqueNick = makeUniqueNick(newNick);
        clientsByNick.put(uniqueNick, out);

        // Broadcast
        broadcastSys("* Eskisi: " + SpecialColor.RED + oldNick + SpecialColor.RESET + "Yenisi:  " + SpecialColor.YELLOW + uniqueNick + SpecialColor.RESET);
        return uniqueNick;
    }

    // WHO_SEND
    public void sendWho(PrintWriter printWriter) {
        List<String> nicks = new ArrayList<>(clientsByNick.keySet());
        Collections.sort(nicks);
        printWriter.println("KİM: " + String.join(",", nicks));
    }
} //end ChatRoom
