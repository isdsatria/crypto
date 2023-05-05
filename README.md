# crypto
mini project training springboot

Terdiri dari 5 microservices yang saling berhubungan melalui kafka.

![image](https://user-images.githubusercontent.com/15684833/236480718-1585228d-9a07-4d0f-8401-536b532522c2.png)

Brief overview mengenai service-service diatas:

**Account-service**  : Penyimpanan & pemrosesan saldo tunai dari customer

**Coin-service**     : Penyimpanan & pemrosesan koin yang tersedia untuk dibeli oleh customer

**Customer-service** : Penyimpanan & pemrosesan detail data customer, beserta asset yang dimiliki (berupa coins)

**Order-service**    : Berfungsi untuk handel transaksi pembelian koin. Ketika transaksi diinisiasi, service ini akan produce message ke topic **orders**, yang nantinya akan diconsume dan diproses oleh : <br>                       
                       - Account-service (via account-kafka-service) yang akan melakukan pengecekan & reserve saldo. Apabila saldo tersedia, maka service akan mengirim message "ACCEPT"  ke topic **payment-orders**, atau "REJECT" ketika saldo tidak tersedia. <br>                          
                       - Coin-service, yang akan melakukan pengecekan & reserve stock coin. Apabila coin tersedia, maka service akan mengirim message "ACCEPT"  ke topic **coin-orders**, atau "REJECT" ketika coin tidak tersedia. <br>                          
                       Apabila kedua service diatas mengirimkan pesan "ACCEPT", maka order-service akan mengirim message "CONFIRMED", yang akan men-trigger proses otorisasi transaksi pada account-service & coin-service, serta penambahan jumlah asset yang dimiliki pada customer-service.
                       
                       
<hr></hr>                    
<b>Terkait Security : </b> Seluruh microservice diatas diset sebagai OAuth2 resource server, menggunakan keycloak sebagai authencation & authorization provider. Konfigurasi keycloak untuk project ini disertakan di dalam project (file keycloak-crypto-base-realm) <br><br>
<b>Terkait database : </b> File export DDL database juga sudah kami sertakan (file **.sql)
                       
