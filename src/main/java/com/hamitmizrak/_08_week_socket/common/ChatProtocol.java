package com.hamitmizrak._08_week_socket.common;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/*
* ChatProtocol ne işe yarar ?
*
* 1-) İstenci(client) ile sunucu(server) konuşma dilini tanımlamak
* - TCP Socket sadece byte akışı(stream) ile taşır ancak mesaj kavramını bilemeyecektir. İşte bundan dolayı mesajı sını olması gerekir (message Boundary) koymak gerekir.
* - En basit tabiriyle : Satır prokolü -> Her mesaj 1 satır ile bitsin
*
*
* 2-) Hangi komutların desteklendiğini  ve server'ın hangi tip cevap vereceğini yani üreteceğini standartlaştırmak gerekir.
*
* Neden satır tabanlı prokol ?
* - Javada BufferedReader.readLine() + PrintWriter.println()
*
*
* 3-) KOMUTLAR (Client -> Server):
* - NICK <name> : Kullanıcı adını ayarla/değiştir
* - MSG <text>  : Herkese yayınoanacak chat mesajı
* - WHO         : Çevirimiçi kullanıcı lsitesini lsitelesin
* - QUIT        : Bağlantıyı kapatsın
*
*
* 4-) KOMUTLAR (Server --> Client)
* - SYS <text>  : Sitem mesajı (join(Katıldı),  Leave(Ayrıldı),  Hata, Bilgilendirme)
*
* - CHAT <nick> <text> : Sohbet mesajı
* - WHO<x,y,z>         : Kullanı ıc listesi
*
* Bu projede JSON kullanılmadı ancak gerçek uygulamalarda şiddetle önerilir.
*
* */
public final class ChatProtocol { // Kalıtım izin vermiyor

    // CTOR (Instance izin vermeiyor)
    private ChatProtocol(){}

    // CONST (Timestamp format zaman damgası)
    private static final DateTimeFormatter TS= DateTimeFormatter.ofPattern("HH:mm:ss").withZone(ZoneId.systemDefault());


    // ts() metodu Ekrana basılan chat mesajının başına zamn damgasını eklemek içindir
    public static String ts(){
        return TS.format(Instant.now());
    }


    /*
    * Kullanıcı mesajı ENTER yani(newline ile girese protokol bozulmasın diye temizler)
    * Amaç: 1 mesaj 1 satır
    * Mesaj içinde server/client bunu yeni mesaja gibi algılar
    *
    * BUNDAN DOLAYI ==> \r ve \n karakterlerini boşlukla değiştiriyoruz
    *
    * */
    public static String sanitize(String message){
        if(message ==null){
            return "";
        }
        return message.replace("\r"," ").replace("\n"," ");
    }

} //end ChatProtocol
