# Socket Programming

```sh 

```
---

## Socket Programming (Sıklıkla Kullanılan Terimler)

```sh 

```
---
Socket dünyası küçük bir “network dili” konuşur. Bu dili öğrenince, log’lar ve hatalar bir anda anlam kazanır. Aşağıda en çok karşılaşacağın socket sözlüğünü **terim → anlam → pratikte ne demek** şeklinde detaylı verdim.

---

## Temel kavramlar

### Socket

* **Anlamı:** İki programın ağ üzerinden veri alışverişi yapabilmesi için kullanılan uç nokta (endpoint).
* **Pratikte:** “Ben şu IP:port’a bağlandım ve byte gönderebiliyorum/okuyabiliyorum.”

### TCP (Transmission Control Protocol)

* **Anlamı:** Bağlantı tabanlı, güvenilir, sıralı iletim protokolü.
* **Ne sağlar:** Paket kaybı olursa tekrar gönderir, veriyi sırayla teslim eder.
* **Pratikte:** Chat, HTTP/HTTPS, DB bağlantıları gibi “doğru ve tam veri gelsin” işleri.

### UDP (User Datagram Protocol)

* **Anlamı:** Bağlantısız, hızlı, “gönderdim gitti” tarzı protokol.
* **Ne sağlar:** Düşük gecikme; ama kayıp/tekrar/sıra garantisi yok.
* **Pratikte:** Oyunlar, canlı yayın, VoIP gibi “birkaç paket kaybolsa da olur” işleri.

### IP Address (IPv4/IPv6)

* **Anlamı:** Ağdaki cihazın adresi.
* **IPv4:** `192.168.1.10` gibi
* **IPv6:** `2001:db8::1` gibi (daha uzun, daha çok adres)

### Port

* **Anlamı:** Aynı IP üzerindeki uygulamaları ayıran kapı numarası.
* **0–65535** arası.
* **Pratikte:** `localhost:8080` → aynı makinede 8080 portunu dinleyen uygulama.

### Endpoint

* **Anlamı:** Genelde `IP:port` ikilisi.
* **Pratikte:** “Sunucu endpoint’i: 127.0.0.1:5555”

---

## Bağlantı ve rol kavramları

### Server (Sunucu)

* **Anlamı:** Bağlantı bekleyen taraf.
* **Java:** `ServerSocket` kullanır.
* **Pratikte:** “Dinler” ve gelen istemcileri kabul eder.

### Client (İstemci)

* **Anlamı:** Bağlantı başlatan taraf.
* **Java:** `Socket(host, port)` ile bağlanır.

### Listen

* **Anlamı:** Sunucunun bir port üzerinde bağlantı beklemesi.
* **Pratikte:** `ServerSocket(5555)` açtın, OS “5555 bende” dedi.

### Accept

* **Anlamı:** Sunucunun gelen bağlantıyı kabul edip yeni bir `Socket` üretmesi.
* **Pratikte:** Bir client gelince `accept()` bloktan çıkar, “o client’a özel” socket verir.

### Connect

* **Anlamı:** Client’ın sunucuya bağlantı kurma girişimi.
* **Pratikte:** Firewall/port kapalıysa hata alırsın.

### Handshake

* **Anlamı:** TCP’de bağlantı kurulurken yapılan 3 aşamalı el sıkışma (SYN, SYN-ACK, ACK).
* **Pratikte:** Bu tamamlanmadan “bağlandım” sayılmaz.

---

## IO ve veri akışı terimleri (Java ile direkt ilgili)

### Stream

* **Anlamı:** Socket’in taşıdığı şey aslında “byte akışı”dır.
* **Önemli:** TCP “mesaj” bilmez, yalnızca akış bilir.

### Message Boundary (Mesaj sınırı)

* **Anlamı:** “Bir mesaj nerede başlıyor nerede bitiyor?”
* **Pratikte:** Şunlardan biriyle çözersin:

    * Satır tabanlı: `\n` ile bitir (`readLine()`)
    * Uzunluk prefix’i: önce “kaç byte” gönder
    * Ayırıcı delimiter: `|` gibi
    * Binary framing (ileri seviye)

### Blocking IO

* **Anlamı:** Okuma/yazma çağrısı veri gelene kadar bekler.
* **Pratikte:** `readLine()` veri yoksa durur, thread bekler.

### Non-blocking IO (NIO)

* **Anlamı:** Okuma/yazma “hazır değilse beklemeden” döner.
* **Pratikte:** Çok client’ı az thread ile yönetmek için kullanılır (Selector).

### InputStream / OutputStream

* **Anlamı:** Socket’in ham byte okuma/yazma kanalları.
* **Java:** `socket.getInputStream()` / `socket.getOutputStream()`

### InputStreamReader

* **Anlamı:** Byte → karakter çevirir (charset ile).
* **Pratikte:** UTF-8 seçmezsen Türkçe karakterlerde saçmalama olur.

### BufferedReader

* **Anlamı:** Buffer’lı okuma yapar ve `readLine()` sağlar.
* **Pratikte:** Satır tabanlı protokoller için kral.

### PrintWriter

* **Anlamı:** Kolay `println()` ile yazı basar.
* **Detay:** `autoFlush=true` verilirse `println` sonrası hemen gönderir.

### Charset / UTF-8

* **Anlamı:** Byte’ların hangi karakterlere denk geldiği.
* **Pratikte:** Server UTF-8, client ISO-8859-9 olursa mesajlar bozulur.

---

## Performans ve kapasite terimleri

### Latency (Gecikme)

* **Anlamı:** Mesajın git-gel süresi.
* **Pratikte:** Chat’te “mesaj geç geliyor” = latency.

### Throughput (Bant genişliği / aktarım)

* **Anlamı:** Birim zamanda taşınan veri miktarı.
* **Pratikte:** Video stream throughput ister, chat latency ister.

### Backpressure

* **Anlamı:** Alıcı yetişemiyorsa göndericiyi yavaşlatma ihtiyacı.
* **Pratikte:** Client yavaşsa server’ın buffer’ı şişer; sonunda hata/timeout.

### Buffer

* **Anlamı:** Geçici veri deposu.
* **Pratikte:** Az buffer = sık sistem çağrısı; çok buffer = RAM.

### Thread-per-connection

* **Anlamı:** Her client için bir thread.
* **Artı:** Basit.
* **Eksi:** Çok client’ta thread sayısı patlar.

### Thread Pool

* **Anlamı:** Sınırlı sayıda thread ile işleri sıraya koyma.
* **Pratikte:** Kaynak kontrolü ve stabilite.

---

## Güvenlik ve ağ katmanı terimleri

### TLS / SSL

* **Anlamı:** Şifreli iletişim katmanı (HTTPS’in temeli).
* **Pratikte:** Düz TCP yerine `SSLSocket` kullanırsan trafik şifrelenir.

### Certificate (Sertifika)

* **Anlamı:** Sunucunun kimliğini kanıtlayan dijital belge.
* **Pratikte:** TLS’te “bu gerçekten o sunucu mu?” sorusunun cevabı.

### Man-in-the-Middle (MitM)

* **Anlamı:** Araya girip trafiği dinleme/değiştirme saldırısı.
* **Pratikte:** TLS yoksa aynı Wi-Fi’da risk büyür.

---

## Çok sık görülen hata/diagnostic terimleri

### Connection Refused

* **Anlamı:** Hedef makineye ulaştın ama o portta dinleyen yok.
* **Sebep:** Server kapalı, yanlış port, firewall reject.
* **Java:** `java.net.ConnectException: Connection refused`

### Timeout

* **Anlamı:** Belirlenen sürede cevap/bağlantı olmadı.
* **Sebep:** Ağ yavaş, server kilitli, paketler drop.
* **Java:** `SocketTimeoutException`

### Connection Reset

* **Anlamı:** Karşı taraf bağlantıyı “sert” biçimde kesti.
* **Sebep:** Uygulama crash, network kopması, firewall.
* **Java:** `SocketException: Connection reset`

### Broken Pipe

* **Anlamı:** Kapanmış bağlantıya yazmaya çalıştın.
* **Sebep:** Client gitti ama server yazmaya devam ediyor.
* **Linux loglarında:** `Broken pipe`

### EOF (End of File)

* **Anlamı:** Okuma tarafı “karşı taraf kapattı” işareti aldı.
* **Pratikte:** `readLine()` null döner.

### Half-Open Connection

* **Anlamı:** Bir taraf bağlantıyı kapattı, diğer taraf hâlâ açık sanıyor.
* **Pratikte:** Keep-alive / heartbeat ihtiyacı doğar.

---

## Protokol ve uygulama katmanı terimleri

### Protocol

* **Anlamı:** “Hangi mesajı nasıl yolluyoruz?” anlaşması.
* **Örnek:** `MSG <text>` ya da HTTP.

### Framing

* **Anlamı:** Mesaj sınırı koyma tekniği.
* **Pratikte:** newline framing, length-prefix framing.

### Serialization

* **Anlamı:** Nesneyi byte’a çevirme.
* **Java:** `ObjectOutputStream` (ama üretimde dikkatli olmak lazım)

### Idempotent

* **Anlamı:** Aynı isteği tekrar gönderince sonuç değişmiyorsa.
* **Pratikte:** Network’te retry yaparken hayat kurtarır.

---

## Socket’te en kritik “akıl taşı” (çok önemli)

**TCP mesaj taşımaz, byte stream taşır.**
Bu yüzden her socket uygulaması şu soruya cevap vermek zorunda:

> “Benim mesajım nerede başlıyor, nerede bitiyor?”

Senin chat örneğinde cevap: **satır tabanlı protokol** (`\n`).

---





## Socket Programming IO/NIO/Stream/Input Terimleri V.S

```sh 

```
---


## 1) `InputStream` nedir?

* **Ham bayt (byte) okuma** kanalıdır.
* Socket’ten gelen veri önce **byte** olarak gelir.
* `socket.getInputStream()` sana bunu verir.

## 2) `Reader` nedir?

* `Reader`, **karakter (text)** okur.
* Byte → karakter dönüşümü gerekir (UTF-8 gibi).

## 3) `InputStreamReader` nedir?

* Köprü (adapter) sınıfıdır: **InputStream (byte)** → **Reader (char)** çevirir.
* Yani socket’ten gelen byte’ları, seçtiğin karakter setine göre metne dönüştürür.

Önemli nokta: Eğer karakter setini belirtmezsen, sistemin varsayılanını kullanır (bazen sorun çıkarır). Pratikte `UTF-8` seçmek güvenlidir.

## 4) `BufferedReader` nedir?

* Bir `Reader`’ı sarar ve **buffer (tampon)** kullanarak okumayı hızlandırır.
* En sevilen özelliği: **`readLine()`** ile satır satır okuyabilmen.
* Yani gelen metin `\n` ile bitiyorsa, “bir satır = bir mesaj” gibi çalışır.

## 5) Bu ikisi neden beraber kullanılır?

Socket’ten veri akışı şu dönüşüm zinciriyle “insan gibi okunur” hale gelir:

`InputStream (byte)` → `InputStreamReader (char)` → `BufferedReader (satır / hızlı okuma)`

Kafada şöyle canlandır:

* **InputStream**: Ham su borusu
* **InputStreamReader**: Suyu “harf çorbasına” çeviren filtre
* **BufferedReader**: Büyük bir sürahi; daha hızlı ve `readLine()` gibi pratik servis yapıyor

---

Aynı mantığın yazma tarafı da var (kısaca):

* `OutputStream` (byte yazar)
* `OutputStreamWriter` (char→byte çevirir)
* `BufferedWriter` veya `PrintWriter` (kolay/hızlı yazar, `println` vs.)


Java Core içinde **socket programlama**, iki programın (çoğunlukla iki farklı bilgisayarın) **TCP/IP ağı üzerinden birbirine bağlanıp veri alışverişi yapmasını** sağlayan, Java’nın standart kütüphaneleriyle (yani “core” ile) yapılan ağ programlamasıdır. Kısaca: **“Ağ üzerinden konuşan iki uç yazmak”**.

---

## 1) Socket tam olarak ne?

**Socket**, işletim sisteminin sağladığı bir “iletişim ucu” (endpoint) gibi düşünülür.

* Bir tarafta **sunucu (server)** vardır: “Ben buradayım, şu kapıdan (port) dinliyorum.”
* Diğer tarafta **istemci (client)** vardır: “O sunucunun IP’sine ve portuna bağlanıyorum.”

Socket, bu iki tarafın **bayt (byte) akışı** gönderebildiği/alabildiği bir kanal açar.

### IP + Port = Adresleme

* **IP adresi**: “Hangi makine?”
* **Port**: “O makinede hangi uygulama/servis?”

Örn: `192.168.1.10:8080` → 192.168.1.10 makinesindeki 8080 portunu dinleyen uygulama.

---

## 2) TCP Socket vs UDP Socket (Java Core’da ikisi de var)

### A) TCP (Transmission Control Protocol)

Java’da çoğu “socket” anlatımı TCP ile başlar çünkü:

* **Bağlantı tabanlıdır** (connection-oriented).
* **Güvenilir**: Veri kaybolmasın diye paketleri takip eder, eksikse tekrar ister.
* **Sıralı**: Gönderdiğin sıra ile gelir.
* **Akış (stream)** mantığı: Karşı tarafa “byte stream” akar.

Java sınıfları:

* `ServerSocket` (sunucu tarafında dinleme)
* `Socket` (istemci tarafında bağlantı + veri kanalı)

### B) UDP (User Datagram Protocol)

* **Bağlantısız** (connectionless).
* **Hızlı** ama **garanti yok**: Paket kaybolabilir, sıra bozulabilir.
* “Mesaj” (datagram) mantığı: Her gönderim ayrı pakettir.

Java sınıfları:

* `DatagramSocket`
* `DatagramPacket`

**Ne zaman hangisi?**

* TCP: chat, dosya transferi, HTTP, güvenilirlik gereken işler
* UDP: oyunlar, canlı yayın/voice, düşük gecikme önemli ama paket kaybı tolere edilebilir işler

---

## 3) TCP Socket’in iç işleyişi (çok önemli)

### 3.1 ServerSocket ne yapar?

Sunucu tarafında 2 aşama var:

1. **Bind + Listen**

* Sunucu bir portu “sahiplenir” ve bekler.
* `new ServerSocket(5555)` dediğinde OS 5555 portunu bu uygulamaya bağlar.

2. **Accept**

* `accept()` çağrısı bloklayıcıdır: bir istemci gelene kadar bekler.
* İstemci gelince, `accept()` sana **yeni bir Socket** döner.
* Bu yeni Socket, artık “o istemci ile konuşma hattıdır”.

> Kritiği: `ServerSocket` “kapı” gibidir; her gelen müşteri için içeride ayrı bir “masa” (Socket) açarsın.

### 3.2 Client Socket ne yapar?

İstemci:

* `new Socket(host, port)` ile sunucuya bağlanır.
* Bağlanınca iki yönlü kanal oluşur:

    * `InputStream` (sunucudan okumak)
    * `OutputStream` (sunucuya yazmak)

### 3.3 TCP 3-way handshake (kafada otursun)

Bağlantı kurulurken tipik olarak:

1. Client → Server: “SYN”
2. Server → Client: “SYN-ACK”
3. Client → Server: “ACK”

Bu sayede bağlantı “kuruldu” sayılır. (Java bunu senin yerine yapar; bilmen performans/timeout/debug için hayat kurtarır.)

---

## 4) Java’da veri okuma-yazma: Stream dünyası

Socket iletişimi Java’da temelde **stream**’lerle yapılır:

* `socket.getInputStream()` → ham bayt okursun
* `socket.getOutputStream()` → ham bayt yazarsın

Ama ham baytla uğraşmak yerine genelde sarmalarsın:

### 4.1 Metin (Text) protokolü

* `InputStreamReader` + `BufferedReader` (satır satır okumak)
* `OutputStreamWriter` + `BufferedWriter` / `PrintWriter`

Örn yaklaşım:

* Karşı tarafa satır satır mesaj gönder: `"HELLO\n"`
* Diğer taraf `readLine()` ile okur.

**Dikkat:** `readLine()` satır sonu (`\n`) gelene kadar bekler → protokolünde satır sonu yoksa kilitlenirsin.

### 4.2 İkili veri (Binary) protokolü

* `DataInputStream` / `DataOutputStream`

    * `writeInt`, `writeUTF`, `readLong` gibi hazır formatlar

**Dikkat:** İkili protokolde “mesaj sınırı” kavramını sen tasarlarsın.
Örn: “Önce 4 byte uzunluk, sonra payload” gibi.

---

## 5) “Mesaj sınırları” meselesi: TCP’de en çok burada yanılırlar

TCP bir **akıştır**. Yani:

* “Ben 10 byte yazdım” demek, karşı tarafın “tek seferde 10 byte okuyacağı” anlamına gelmez.
* 10 byte, 2 parçada (6+4) gelebilir veya 20 byte birikmişken tek seferde 20 okuyabilirsin.

Bu yüzden **uygulama protokolü** şart:

* Satır tabanlı: `\n` ile bitir
* Uzunluk önekli: önce `int length`, sonra o kadar byte oku
* Özel delimiter: `|END|` gibi (metinde riskli)

Bu konuyu kavrarsan socket programlamanın %60’ını çözmüş olursun.

---

## 6) Eşzamanlılık (Concurrency): Sunucu aynı anda çok istemciyi nasıl kaldırır?

Tek bir thread ile:

* `accept()` → client1 geldi
* client1 ile konuş → bu sırada client2 bekler (kötü)

Gerçek sunucu yaklaşımı:

* `accept()` ile her client gelince **bir thread** veya **thread pool** ile onu ayrı ele alırsın.

Java Core’da tipik:

* `ExecutorService` (thread pool) kullanılır.
* Her client bağlantısı “handler” (Runnable/Callable) olarak pool’a verilir.

**Neden thread pool?**

* Sınırsız thread açmak (her client’a thread) bir süre sonra sistemi öldürür.
* Pool, kontrollü kaynak yönetimi sağlar.

---

## 7) Blocking I/O vs Non-blocking I/O (NIO)

### 7.1 Klasik IO (java.net + java.io)

* `accept()`, `read()` bloklar → thread bekler.
* Basit ve öğreticidir.

### 7.2 Java NIO (java.nio.channels)

* `ServerSocketChannel`, `SocketChannel`
* `Selector` ile tek thread çok bağlantıyı yönetebilir (non-blocking/multiplexing).
* Yüksek ölçekli sunucularda (binlerce bağlantı) daha verimli olur.

Socket programlama öğrenirken sıra genelde:

1. IO ile mantığı öğren
2. NIO ile ölçek mantığını öğren

---

## 8) Timeout, keep-alive ve bağlantı kapanması

### 8.1 Timeout

* `socket.setSoTimeout(ms)` → `read()` belirli süre veri gelmezse `SocketTimeoutException`
* Sunucu tarafında “ölü bağlantılar” için önemlidir.

### 8.2 Bağlantı kapanması nasıl anlaşılır?

* Karşı taraf düzgün kapatırsa, `read()` genelde `-1` döner (stream bitti).
* Metin okuyorsan `readLine()` `null` dönebilir.

### 8.3 “Neden kapanmıyor?” klasiği

* Buffer’lı yazıcı kullanıp `flush()` etmezsen veri karşıya gitmeyebilir.
* Ya da protokolde satır sonu yoksa karşı taraf bekler.

---

## 9) Basit bir “protokol” örneği (tasarım düşüncesi)

Diyelim mini bir komut setin var:

* `PING` → `PONG`
* `ECHO <mesaj>` → aynı mesajı geri döndür
* `TIME` → sunucu saati
* `BYE` → bağlantıyı kapat

Bu bir “application protocol”dür. TCP sadece taşıyıcıdır; “ne konuşacağız?” kısmı senin tasarımındır.

---

## 10) Güvenlik ve gerçek hayat notları (Core seviyede bile önemli)

* **TLS/SSL**: Şifreli iletişim için `SSLSocket` / `SSLServerSocket` (javax.net.ssl) kullanılır.
* **Kimlik doğrulama**: Basit token, API key, ya da challenge-response.
* **Input validation**: Karşı taraf “kötü niyetli” olabilir; gelen veriye güvenme.
* **DOS riskleri**: Devasa mesaj gönderip RAM’i şişirebilir. Mesaj uzunluğuna limit koy.

---

## 11) Socket programlamanın tipik kullanım alanları

* Chat uygulamaları, canlı bildirim sistemleri
* IoT cihazlarıyla konuşma
* Oyun sunucuları (TCP/UDP karışık)
* Dosya transfer protokolleri
* Kendi mikro servislerin arası özel protokol (çoğu zaman HTTP yerine daha düşük seviye)

Ama modern dünyada çoğu iş HTTP/gRPC/WebSocket gibi üst seviye protokollerle yapılır. Socket bilmek yine de alt katmanı anlamanı sağlar: debug, performans, bağlantı yönetimi, timeout, streaming…

---

## 12) “Java Core socket programlama öğrenirken” en sık yapılan hatalar

* TCP’de mesaj sınırı yokmuş gibi davranmak (en büyük hata)
* `flush()` unutmak
* Her client için thread açıp thread patlaması yaşamak
* Timeout ayarlamamak (sunucu sonsuza kadar bekler)
* Charset/encoding karışıklığı (`UTF-8` vs platform default)
* Kapanış sırasını doğru yönetmemek (`close()`)

---

