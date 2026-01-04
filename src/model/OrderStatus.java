package model;

/**
 * Siparişin anlık durumunu belirten sabitler (Enum).
 */
public enum OrderStatus {
    RECEIVED,    // Sipariş Alındı
    PREPARING,   // Hazırlanıyor
    READY,       // Hazır (Kurye Bekleniyor)
    ON_THE_WAY,  // Yolda
    DELIVERED,   // Teslim Edildi
    CANCELLED    // İptal Edildi
}