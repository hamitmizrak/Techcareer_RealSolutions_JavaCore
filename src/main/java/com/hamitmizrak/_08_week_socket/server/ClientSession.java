package com.hamitmizrak._08_week_socket.server;

import com.hamitmizrak._08_week_socket.common.ChatProtocol;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/*
 *
 * */
public class ClientSession implements Runnable {

    //FIELD
    private final Socket socket;
    private final ChatRoom room;

    // CTOR(PARAM)
    public ClientSession(Socket socket, ChatRoom room) {
        this.socket = socket;
        this.room = room;
    }

    // THRED RUN
    @Override
    public void run() {

        String remote = String.valueOf(socket.getRemoteSocketAddress());
        String nick = null;

        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true)
        ) {
            out.println("SYS Hoşgeldiniz JavaChat Komutlar: /nick <name>,  /who,  /quit");

            String line;
            while ((line = in.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                if (nick == null) {
                    if (line.toUpperCase().startsWith("NICK ")) {
                        nick = room.join(line.substring(5).trim(), out);
                        continue;
                    } else {
                        nick = room.join("Guest", out);
                        out.println("SYS Takma Adınız: " + nick);
                    }
                }

                String upper = line.toUpperCase();

                // WHO
                if (upper.equals("WHO")) {
                    room.sendWho(out);
                    continue;
                }

                // QUIT
                if (upper.equals("QUIT")) {
                    out.println("SYS iyi günler");
                    break;
                }

                // NICK
                if (upper.startsWith("NICK ")) {
                    String desired = line.substring(5).trim();
                    nick = room.changeNick(nick, desired, out);
                    out.println(("SYS Mahlas(Takma Ad) " + nick));
                    continue;
                }

                // MSG
                if (upper.startsWith("MSG ")) {
                    String msg = line.substring(4);
                    room.broadcastChat(nick, ChatProtocol.ts() + " " + msg);
                    continue;
                }

                room.broadcastChat(nick, ChatProtocol.ts() + " " + line);
            }

        } catch (Exception e) {
            // throw new RuntimeException(e);
            System.out.println("Client error: (" + remote + "): " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (Exception ignore) {
                ignore.printStackTrace();
            }
            room.leave(nick);
            System.out.println("Client disconnected " + remote);
        }

    } //end run
} //end ClientSession
