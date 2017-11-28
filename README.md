# RememberMe

İngilizce kelime öğrenme uygulaması. 

## 1 - Kapsam

Öğrencilerin ingilizce kelime dağarcıklarını geliştirmek için kullanacakları bir uygulamadır. Öğrenciler kendi karşılaştıkları sözcükleri ekleyerek kendi egzersiz sözlüğünü oluşturacak, ayrıca uygulamada hazır bulunan sözcük listeleriyle de (Temel 100 sözcük, tatil, yemek gibi kategoriler) egzersiz yapabileceklerdir. Egzersiz sayfasında soru olarak, sorulan sözcük için üç rastgele bir doğru tanım içerisinden veya sorulan rastgele bir tanım için üç rastgele bir doğru sözcük içerisinden doğruyu seçmesi beklenecektir.
Sözcüklerin sorulma sayıları ve doğru cevap sayıları database'de tutulacak, az sorulan veya çok fazla yanlış cevap verilen soruların daha sık karşısına çıkması sağlanacaktır.

Uygulama, indirdiği sözcük listeleri veya kendi sözlüğü üzerinden çevrimdışı çalışabilecektir. Telaffuz özelliği hariç, uygulama çevrimdışı kullanılabilinecektir. 

## 2 - Proje Yapısı

    .
    ├── app                     # Uygulama konfigürasyonunun yapılacağı Application classı.
    ├── data                    # Database controller ve data alışverişiyle ilgili classlar
    ├── model                   
    │   ├── dto                 # Uygulama içinde kullanılacak objeler
    │   └── realm               # Realm Objeleri
    └── module
        ├── addnewword          # Uygulamadaki activity ve presenter class'ları ve o activity'de kullanılacak adapterlar.
        ├── main  
        └── wordlist 

    .
    ├── test                     # Unit test classları.
    └── androidTest              # Instrumented ve UI test classları.
    



## 3 - Kullanılan ve Kullanılacak 3üncü Parti Kütüphaneler.


#### Realm

Uygulamada database olarak realm kullanılmaktadır. SQLite'dan daha performanslı çalışması ve nesnelerle çalışmak için tercih edilmiştir. 

#### JUnit

Unit testler için kullanılacaktır. 

#### Espresso

UI testleri için kullanılacaktır. Proje UI olarak karmaşık olmadığı için daha az UI testi yazılacaktır. Bu yüzden Robolectric gibi JVM üzerinde daha hızlı çalışacak bir kütüphaneye ihtiyaç yoktur.

#### Retrofit

Detaylı dökümantasyon ve web servis haberleşmesinde sağladığı kolaylıklar için tercih edilmiştir. 

#### Dagger 2

Test edilebilir bir kod ortaya çıkarmak için dependency injection yapmak gerekmektedir. Modüllerin birbirine bağımlılığını ortadan kaldırmak için Dagger kullanarak injection sağlanacaktır.

#### Butterknife

View injection için kullanılacaktır. 



## 4 - Teknik Detaylar ve Akış

Projede MVP mimarisi kullanılmıştır. Yani yaratılacak her activity için **module** altına o activity için bir package ve o package'ın presenterı da yaratılacaktır. 

Data altındaki RealmController database işlemlerinin gerçekleştiği modüldür. Presenterlar data alışverişi için doğrudan DataAccessInterface'i kullanacaklardır. Database değişikliği olması durumunda DataAccessCreator'ın yeni Database controller'ı dönmesi sağlanacaktır. Activity ve Presenter classları içinde DB kodu bulundurulmayarak bağımlılık kaldırılmıştır.

Model altında Database objeleriyle Data Transfer Objeleri birbirinden ayrılmıştır.

## 5 - Proje Durumu

- [x] Sözcük ekleme ve düzenleme
- [x] Kendi sözcüklerini görüntüleme
- [ ] Hazır sözcükleri görüntüleme ve indirme
- [ ] Bir sözcük listesiyle egzersiz yapma




