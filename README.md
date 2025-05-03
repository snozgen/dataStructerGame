# 🎮 Treasure Hunt Adventure

Veri yapıları eğitimi için geliştirilen bu oyun, oyunculara hem eğlenceli hem de öğretici bir deneyim sunar. Oyunun temelinde **bağlı listeler** ve **Binary Search Tree (BST)** gibi yapılar yer alır. Oyun Java Swing arayüzüyle geliştirilmiş olup iki seviyeden oluşur.

---

## 🖼️ Giriş Ekranı



Oyuncudan kullanıcı adı alır, oyun başlatılır veya skor geçmişi görüntülenir.

---

## 🗂️ 1. FileManager Sınıfı

Skorları dosyaya kaydeder ve okur. Ayrıca skorları `scoreBST` yapısına yükler.

### 🔹 Önemli Metotlar

- **saveScore(String username, String level, int score)**  
  - Skoru `score.txt` dosyasına `"kullanıcı,level,puan"` formatında ekler.
  - `BufferedWriter` ve `FileWriter` ile dosyaya yazma yapılır.
  - Var olan verileri silmeden sona ekleme yapılır.
  - IOException durumunda hata mesajı basılır.

- **loadScoresToBST(scoreBST bst)**  
  - Dosyadaki skorları okuyarak BST’ye ekler.
  - Her satır `split(",")` ile ayrılır ve geçerli olanlar BST’ye yerleştirilir.

---


## 🧩 2. cellNode Sınıfı

Her bir oyun hücresini temsil eder.

### 🧱 Alanlar

- `JButton button` → Hücreye karşılık gelen buton.
- `String cellType` → Hücre tipi: `"trap"`, `"treasure"`, `"empty"` vs.
- `cellNode next, prev` → Tek veya çift yönlü bağlantılar.

### 🔨 Constructor

- Hücre tipi atanır, `next` ve `prev` başta `null`.

---

## 🕹️ 3. levels Sınıfı (Level 1)


### 🎯 Oyun Mantığı

- 29 hücreli tek yönlü bağlı liste.
- Hücrelerde `"trap"`, `"treasure"` veya `"empty"` olabilir.
- Zar atışıyla ilerlenir, puan güncellenir, seviye sonunda skor kaydedilir.

### 🎲 btn_rollDiceActionPerformed

- Zar sonucu kadar ileri gidilir.
- Hücreye göre puan artar/azalır.
- Seviye tamamlanınca Level 2 başlatılır.

---

## 🧭 4. levels2 Sınıfı (Level 2)

> 📸 Ekran görüntüsü için buraya görsel eklenecek  
> `![Level 2](images/level2.png)`

### 🎯 Oyun Mantığı

- 30 hücreli çift yönlü bağlı liste.
- Hücre Tipleri:
  - `"trap"`, `"treasure"`, `"empty"`
  - `"moveforward"`: 2 hücre ileri
  - `"movebackward"`: 2 hücre geri
  - `"grandtreasure"`: +50 puan
  - `"death"`: oyun biter

### 🎲 btn_diceActionPerformed

- Zar atılır ve hareket edilir.
- Hücre tipine göre puan veya pozisyon değişir.
- `"death"` gelirse oyun biter ve skor kaydedilir.

---

## 🌲 5. scoreBST Sınıfı

Skorlar Binary Search Tree (BST) yapısında saklanır ve analiz edilir.

### 🔹 Metotlar

- **insert(String username, String level, int score)**  
  Skoru BST’ye ekler (küçükse sola, büyükse sağa).

- **appendInOrder(StringBuilder sb)**  
  Skorları küçükten büyüğe metin olarak ekler (`append` metodu kullanılır).

- **getBestScore()**  
  En sağdaki düğüm = en yüksek skor

- **getWorstScore()**  
  En soldaki düğüm = en düşük skor

- **printScoresWithBestWorst()**  
  Skorları sıralı gösterir ve en iyi/en kötü skoru belirtir.

---

## 🧠 6. append vs add

- **append** → `StringBuilder` ile metin oluşturmak için.
- **add** → Koleksiyonlara (List, Set) eleman eklemek için.

```java
sb.append("skor bilgisi");
list.add("skor bilgisi");
