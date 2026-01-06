package model;

/**
 * Siparişin anlık durumunu belirten sabitler.
 * Türkçe açıklamalar eklendi.
 */
public enum OrderStatus {
    RECEIVED("Sipariş Alındı"),
    PREPARING("Hazırlanıyor"),
    READY("Hazır (Kurye Bekleniyor)"),
    ON_THE_WAY("Yolda"),
    DELIVERED("Teslim Edildi"),
    CANCELLED("İptal Edildi");

    private final String description; // Türkçe açıklama alanı

    // Constructor (Kurucu Metot)
    OrderStatus(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}