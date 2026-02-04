public class Not {
}
// ===============================================
// CITY EXPLORER PROJESİ
// Açıklama ve Design Pattern Kullanımı Notları
// Hazırlayan:Nisa Doğa Yücel
// ===============================================


/*
 * Bu projede, şehirleri sıralayıp, hava durumuna göre filtreleyip,
 * kullanıcıya özel gezilecek yer planı oluşturulan bir GUI (Swing) uygulaması geliştirdim.
 * Aynı zamanda pie chart ve bar chart ile görsel veri sunumu da sağlanıyor.
 * Projede toplam 5 temel design pattern uyguladım.
 *
 * -------------------------------
 *  1. Singleton Pattern
 * -------------------------------
 * ➤ Uygulama boyunca tüm şehir verisine tek noktadan ulaşmak için
 *    CityRepository sınıfı Singleton olarak tanımlandı.
 * ➤ getInstance() metodu ile her yerden aynı nesneye erişilebiliyor.
 *
 * -------------------------------
 *  2. Strategy Pattern
 * -------------------------------
 * ➤ Şehirleri sıralamak için farklı algoritmalar (isme, alana, nüfusa göre)
 *    SortStrategy arayüzü üzerinden tanımlandı.
 * ➤ SortByName, SortByPopulation, SortByArea sınıfları bu stratejileri uyguluyor.
 * ➤ CitySorter sınıfı context olarak görev yapıyor, GUI'deki seçimlere göre strateji atanıyor.
 *
 * -------------------------------
 *  3. Iterator Pattern
 * -------------------------------
 * ➤ Hava durumuna göre (RAINY, SUNNY, SNOWY, CLOUDY) şehirleri filtrelemek için
 *    özel iterator sınıfları yazıldı.
 * ➤ WeatherIterator arayüzü üzerinden tüm hava durumu sınıfları oluşturuldu.
 * ➤ WeatherFilter sınıfı bu iterator'ları kullanarak GUI'deki ComboBox'a göre listeyi filtreliyor.
 *
 * -------------------------------
 *  4. Observer Pattern
 * -------------------------------
 * ➤ WeatherProvider sınıfı arka planda sürekli hava durumu ve sıcaklık değiştiriyor (3 saniyede bir).
 * ➤ BarChartPanel ve PieChartPanel sınıfları observer olarak tanımlandı.
 * ➤ Bu sayede grafikler canlı olarak güncelleniyor.
 *
 * -------------------------------
 *  5. Decorator Pattern
 * -------------------------------
 * ➤ Kullanıcı şehir seçtiğinde ve "müze, alışveriş, park" gibi aktiviteleri işaretlediğinde
 *    bu aktiviteler şehre sarmalanarak ekleniyor.
 * ➤ CityActivity soyut sınıfı temel bileşen, BaseCity concrete bileşen.
 * ➤ VisitMuseum, VisitShoppingMall, VisitCityCenter gibi sınıflar decorator.
 * ➤ VisitPlannerPanel bu sistemi GUI ile entegre ediyor.
 *
 * -------------------------------
 *  Diğer Yapılar
 * -------------------------------
 * ➤ MainFrame sınıfı tüm GUI düzenini içeriyor. 3 ana bölge: filtreleme üst paneli, listeler/planlayıcı orta paneli, grafikler alt paneli.
 * ➤ Main.java içinde JSON verisi yükleniyor ve arayüz başlatılıyor.
 * ➤ City sınıfı tüm şehir verilerini taşıyan temel sınıf.
 *
 * -------------------------------
 *  Genel Not:
 * -------------------------------
 * ➤ Bu proje Java Swing, JSON veri işleme, çoklu design pattern ve görsel arayüzü bir araya getiriyor.
 * ➤ Projeyi yazarken en çok Decorator Pattern ve Observer Pattern kısmı üzerinde yoğunlaştım.
 * ➤ Kodlarımı temiz, yorumlu ve yeniden kullanılabilir şekilde yazmaya dikkat ettim.
 *
 * Hazırlayan:Nisa Doğa Yücel 220201012
 */




//CityRepository → Singleton
//
//Sort Strategy + CitySorter → Strategy
//
//WeatherFilter + WeatherIterator → Iterator
//
//WeatherProvider + Pie/Bar Chart → Observer
//
//VisitPlannerPanel ve aktiviteler → Decorator