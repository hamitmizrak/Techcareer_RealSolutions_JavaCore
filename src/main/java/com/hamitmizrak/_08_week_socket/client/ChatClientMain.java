package com.hamitmizrak._08_week_socket.client;

/*
 * Bu sınıf terminalde çalışan basit bir chat programıdır (Socket Progrraming)
 *
 * Bu sınıfta iki paralel akış diyagramı vardır.
 *
 * 1-) Okuyucu thread((Reader)
 *   - Server'dan gelen satırları sürekli okur
 *   - SYS/CHAT/WHO komutları(Mesajlarını ekranda gösteririr)
 *   - Böyle biz yazı yazarkende mesajlar alabiliriz.
 *
 * 2-) Ana Thread (Main):
 * - Klavyeden satır satır okur(Scanner)
 * - Komutları server protokülne çevirir ve gönderirir.
 *
 * Neden iki Thread kullanıyıruz ?
 * - Tek thread ile hem klavye okuma hemde socket okuma aynı anda zordur.
 * - Server mesajı geldiğinde kullanıcı henüz basmamışsa bile gelen mesjaı görmek ister
 *
 * Argümanlar
 * - host: localhost(127.0.0.1)
 * - port: 5555
 *
 * Client Komutları
 *   /nick <name>  -> server'a  NICK<name>
 *   /who          -> server'a  WHO
 *   /quit         -> server'a  QUIT
 *
 * */

import com.hamitmizrak._08_week_socket.PORT_HOST_OTHER;
import com.hamitmizrak._08_week_socket.SpecialColor;
import com.hamitmizrak._08_week_socket.common.ChatProtocol;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClientMain {

    /*
     * Server'dan gelen mesajları daha iyi okunabilir hale getirir.
     * - SYS -> [SYS] prefix
     * - WHO -> [WHO] prefix
     * - CHAT <nick> <msg> -> "nick: msg" formatına çevirir
     * */
    private static String pretty(String line) {
        // null
        if (line == null) {
            return "";
        }

        // SYS
        if (line.startsWith("SYS ")) {
            return "[SYS] " + line.substring(4);
        }

        // SYS
        if (line.startsWith("CHAT ")) {

            int firstSpace = line.indexOf(" ");
            int secondSpace = line.indexOf(" ", firstSpace + 1);
            if (secondSpace > 0) {
                String nick = line.substring(firstSpace + 1, secondSpace);
                String msg = line.substring(secondSpace + 1);
                return SpecialColor.GREEN + nick + SpecialColor.RESET + ": " + SpecialColor.YELLOW + msg + SpecialColor.RESET;
            }
        }

        if (line.startsWith("WHO ")) {
            return "[WHO] " + line.substring(4);
        }
        return line;
    }

    /*
     * Server'dan gelen mesajları sürekli okur ve ekranda gösterir
     * DİKKAAAATTT : Bu metot ayrı bir thread içinde çalışır.
     *
     *
     *  */
    private static void readLoop(BufferedReader bufferedReader) {
        String line = "";
        try {
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("\n" + pretty(line));
                System.out.println(SpecialColor.BLUE + "> " + SpecialColor.RESET);
            }
        } catch (IOException ioException) {
            System.out.println("\nBağlantı kapatıldı: [ " + SpecialColor.RED + ioException.getMessage() + SpecialColor.RESET + "]");
        }
    }


    // PSVM
    public static void main(String[] args) throws Exception {

        // HOST
        String host = PORT_HOST_OTHER.HOST;
        Integer port = PORT_HOST_OTHER.PORT;

        if (args.length >= 1) {
            host = args[0];
        }

        if (args.length >= 2) {
            port = Integer.parseInt(args[0]);
        }

        System.out.println("Bağlantı : " + SpecialColor.CYAN + host + ":" + port + SpecialColor.RESET + " ...");

        // Socket Bağlantısı
        // host:port TCP ile bağlanır
        // Eğer bağlantı kurulmazsa burada exception alınsın ve server kapalı mesajı versin

        // java.net.Socket
        try (
                // Socket
                Socket socket = new Socket(host, port);

                // BufferedReader
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

                // PrintWriter
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

                Scanner scanner = new Scanner(System.in)) {
            // Server'den gelen mesajları anlık okumak için
            // Daemon thread olduğu için , main thread bittiğinde otomatik kapansın
            Thread reader = new Thread(
                    () -> readLoop(in),
                    "Server-reader");

            // Bu thread JVM'i ayakta tutsun
            // Kullanıcı /quit yaptığında uygulamaya rahatlıkla kapatabilsin
            reader.setDaemon(true);
            reader.start();

            // Kullanıcı isterse NICK yazdığında, NICK yazabilir.
            // Boş bırakırsa server otomatik olarak "Guest" atasın
            System.out.println("Nick giriniz (Default:  Guest)");
            String nick = scanner.nextLine().trim();
            if(!nick.isBlank()){
                out.println("NICK: "+ ChatProtocol.sanitize(nick));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


} //end ChatClientMain
