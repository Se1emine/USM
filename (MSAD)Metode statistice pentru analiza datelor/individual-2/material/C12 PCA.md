# **PCA**

_**Presenter**_


**Valeriu Ungureanu**


_**Data**_


_**Wednesday, 8 April 2026**_


_**Moldova State University**_


_MStAD_


**2** _C12 PCA.nb_

#### **PCA: metoda componentelor principale**

## **Metoda componentelor principale**


Succint, metoda componentelor principale ( _**P**_ _rincipal_ _**C**_ _omponent_ _**A**_ _nalysis_ ) este o metodă
liniară de reducere a dimensionalității care identifică direcțiile ortogonale (componentele
principale) ce maximizează varianța datelor.

### **1. Ce este PCA?**


PCA ca tehnică statistică este utilizată pentru _reducerea dimensionalității datelor_, păstrând
în același timp cât mai multă informație relevantă.


Ideea centrală este de **a transforma un set de variabile corelate într-un nou set de**
**variabile necorelate** ( _numite componente principale_ ), ordonate în funcție de varianța pe
care o explică.


Așadar, PCA este o metodă de reducere a dimensionalității care transformă datele într-un
nou sistem de coordonate astfel încât:


  - _prima componentă principală maximizează varianța_,


  - componentele următoare _sunt ortogonale_ și _captează cât mai mult din varianța rămasă_ .


Intuitiv, **PCA reduce dimensionalitatea datelor prin proiectarea acestora pe direcțiile**
**care păstrează cea mai mare parte a varianței inițiale** .

### **2. Obiectivul PCA**


 Simplificarea reprezentării datelor de dimensiune mare, prin **reducerea numărului de**

**variabile** (dimensionalității).


 **Eliminarea redundanței**, determinată de corelațiile existente între variabile.


 **Facilitarea vizualizării datelor complexe**, prin proiecția acestora în spații de dimensiune

redusă (de regulă 2D sau 3D).


 **Îmbunătățirea performanței algoritmilor de învățare automată**, prin reducerea zgomo
tului și a costurilor computaționale.

### **3. Pașii principali în PCA**


**1.** **Standardizarea datelor**   - pentru ca variabilele cu scări diferite să nu distorsioneze

rezultatele.


**2.** **Calcularea matricei de covarianță (sau corelație)**   - evidențiază relațiile dintre variabile.


_C12 PCA.nb_ **3**


**3.** **Determinarea valorilor și vectorilor proprii**   - valorile proprii indică varianța explicată,
iar vectorii proprii definesc direcțiile componentelor principale.


Pentru o matrice 𝐴, un vector nenul 𝑣 este vector propriu dacă:


𝐴 𝑣 = 𝜆 𝑣


unde:


𝑣 = vector propriu (direcție invariantă)


𝜆 = valoare proprie (factor de scalare)


**Vectorii proprii** sunt direcții care își **păstrează orientarea** sub acțiunea unei transformări
liniare, iar **valorile proprii** **cuantifică factorul de scalare** asociat fiecărei direcții.


**4.** **Sortarea și selecția componentelor principale**   - primele componente rețin cea mai

mare parte a informației.


**5.** **Proiecția datelor originale pe noile axe** (componentele principale).

### **4. Exemple de utilizare**


**Recunoașterea facială** : reducerea dimensionalității imaginilor pentru extragerea trăsăturilor esențiale.


**Genomică** : identificarea tiparelor din seturi masive de date genetice.


**Finanțe** : reducerea numărului de indicatori economici pentru modelare.


**Vizualizare** : reprezentarea datelor multidimensionale în grafice 2D/3D.

### **5. Avantaje, limitări, flux și rezultat**


**Avantaje** : simplifică datele, reduce zgomotul, accelerează calculele, îmbunătățește
vizualizarea.


**Limitări** : pierdere de informație (dacă se aleg prea puține componente), interpretarea
componentelor nu este mereu intuitivă.


**4** _C12 PCA.nb_


**Fluxul algoritmului PCA**











**Rezultatul algoritmului PCA poate fi privit pe mai multe niveluri:**


1. Componentele principale


**Vectori proprii ai matricei de covarianță** (sau corelație).


Fiecare componentă principală este - direcție nouă în spațiul datelor, ortogonală pe
celelalte.


Ele definesc un nou sistem de coordonate care maximizează varianța datelor pe primele
axe.


_C12 PCA.nb_ **5**


2. Valori proprii și varianța explicată


**Fiecărei componente principale îi corespunde o valoare proprie** → **măsoară câtă**
**varianță din date explică acea componentă** .


Putem calcula proporția de varianță explicată de fiecare componentă și varianța cumulată.


Aceasta ne ajută să alegem numărul optim de componente k.


3. Reprezentarea redusă a datelor


Rezultatul practic este o proiecție a datelor originale în spațiul celor mai importante _k_ componente principale:


_X_ redus = _X Wk_


unde:


X - matricea datelor standardizate,


_Wk_   - matricea formată din primii k vectori proprii (componente principale),


_X_ redus - datele reprezentate într-un spațiu cu dimensionalitate redusă.


4. Beneficii practice ale rezultatului


**Reducerea** **dimensionalității** : elimină redundanța și zgomotul, păstrând informația
esențială.


**Vizualizare** : date complexe (de ex. cu 100 de variabile) pot fi reprezentate în 2D sau 3D pe
primele componente.


**Preprocesare pentru Machine Learning** : accelerează algoritmii și reduce overfitting.


**Pe scurt** : rezultatul PCA este un spațiu redus al datelor (spațiul PC [k] ), obținut prin proiecția
datelor originale pe primele componente principale, împreună cu informația despre câtă
varianță explică fiecare componentă.

### **6. Exemplu simplu**


**Fluxul complet al PCA pe un exemplu simplu**


Avem 10 observații cu 2 variabile puternic corelate (aprox. liniare).


**6** _C12 PCA.nb_


1. Introducerea datelor







2. Calculul mediei pentru fiecare variabilă


PCA pornește prin centrarea datelor, adică scădem media fiecărei coloane.









3. Centrarea datelor





sau mai compact:





Putem vedea rezultatul:


_C12 PCA.nb_ **7**









4. Verificare: media datelor centrate trebuie să fie 0









5. Matricele de covarianță și de corelație


Reamintin, covarianța dintre două variabile este definită ca media produselor abaterilor față
de mediile lor, oferind o măsură a variației comune a acestora, dependentă de unitățile de
măsură:



cov( _X_, _Y_ ) =



∑ _ni_ =1 ( _xi_ - _x_ ) ( _yi_ - _y_ )

_n_   - 1



iar corelația este standardizată în [−1,1], fiind comparabilă între variabile:



_r_ XY =





∑ _i_ =1



_ni_ =1 ( _xi_ - _x_ ) ( _yi_ - _y_ )



cov( _X_, _Y_ )


σ _X_ σ _Y_



Matricele centrale ale PCA în exemplul nostru:








**8** _C12 PCA.nb_


sau direct:















unde pe diagonală sunt dispersiile variabilelor coresponzătoare, iar în afara diagonalei - cât
de mult variază împreună variabilele.


Pentru matricea de corelație:











6. Valorile proprii și vectorii proprii


Aceștia definesc direcțiile principale și cantitatea de varianță explicată.







Afișare:









sau mai clar:


_C12 PCA.nb_ **9**









În PCA, **valorile proprii sunt nenegative**, deoarece matricea de covarianță (sau de corelație) este simetrică și pozitiv semidefinită; apariția unor valori proprii negative semnificative
indică o problemă de modelare sau de calcul.


7. Sortarea descrescătoare după valorile proprii


În PCA, componentele se ordonează după varianța explicată.







Verificare:









8. Varianța explicată și proporția varianței explicate





Afișare:


**10** _C12 PCA.nb_









Varianța cumulată:









9. Formarea matricei componentelor principale


În mod uzual, matricea de proiecție se construiește din vectorii proprii sortați.











Aici:


coloana 1 = PC1,


coloana 2 = PC2


10. Proiectarea datelor pe noile axe principale și biplotul


Scorurile PCA (noile coordonate ale punctelor) se obțin prin:







Afișare:


_C12 PCA.nb_ **11**











Acestea sunt coordonatele observațiilor în noul sistem de axe (𝑃𝐶1, 𝑃𝐶2).


Biplotul (două tipuri de obiecte reprezentate simultan: observații - puncte albastre, variabile

- vectori roșii):







2 vectori: unghi ≈ 90° → variabile aproape necorelate, direcții opuse pe verticală → contribuții diferite pe PC2. Observațiile sunt răspândite mai mult pe axa PC1 - explică majoritatea variației.


**12** _C12 PCA.nb_


11. Tabel cu scorurile PCA


_O u t [_  _] =_

|Observație|PC<br>1|PC<br>2|
|---|---|---|
|1|0.828|-0.175|
|2|-1.778|0.143|
|3|0.992|0.384|
|4|0.274|0.130|
|5|1.676|-0.209|
|6|0.913|0.175|
|7|-0.099|-0.350|
|8|-1.145|0.046|
|9|-0.438|0.018|
|10|-1.224|-0.163|



Valorile pe PC1: variază între ≈ -1.78 și 1.68,
mult mai mari decât pe PC2, ceea ce înseamnă că PC1 capturează structura principală a
datelor.


Tabelul scorurilor PCA reprezintă coordonatele observațiilor în baza ortogonală definită de
componentele principale, permițând analiza structurii datelor, identificarea grupărilor și
reducerea dimensională.


_C12 PCA.nb_ **13**


12. Reprezentarea punctelor inițiale






**14** _C12 PCA.nb_


13. Reprezentarea scorurilor PCA în planul componentelor principale






|Col1|Col2|0.4|Col4|Col5|Col6|
|---|---|---|---|---|---|
|||~~0.2~~<br>||||
|||||||
|.5<br>-1|.0<br>-0|.5<br>~~0.2~~|0.|5<br>1.|0<br>1.|


_C12 PCA.nb_ **15**


14. Etichetarea observațiilor în planul PCA























|Col1|Col2|Col3|Col4|Col5|Col6|Col7|
|---|---|---|---|---|---|---|
||||~~0.2~~<br>~~0.4~~||||
|||8|9<br>|4||~~6~~|
|.5|10<br>-1|.0<br>-0|.5<br>|0.|1<br>5<br>1.|0<br>1.|
|.5|||||||


15. Reducerea dimensionalității la o singură componentă principală

Dacă vrem să păstrăm doar 𝑃𝐶1:







sau echivalent:





Acestea sunt coordonatele observațiilor pe prima componentă principală.






**16** _C12 PCA.nb_


16. Reconstrucția aproximativă din prima componentă


Acesta este pasul clasic de reducere dimensională:





Afișare:







|Obs.|x reconstruit<br>1|x reconstruit<br>2|
|---|---|---|
|1|2.371|2.519|
|2|0.605|0.603|
|3|2.483|2.639|
|4|1.996|2.112|
|5|2.946|3.142|
|6|2.429|2.581|
|7|1.743|1.837|
|8|1.034|1.069|
|9|1.513|1.588|
|10|0.980|1.010|


Aceasta este aproximarea datelor originale folosind doar prima componentă principală.


_C12 PCA.nb_ **17**


17. Compararea datelor originale cu reconstrucția

















18. Varianta compactă, completă, într-un singur bloc


Tot fluxul PCA într-un singur script:


**18** _C12 PCA.nb_





19. Interpretare didactică a pașilor


Succesiunea logică a PCA este:


**0.1.** Date brute
**0.2.** Calculul mediilor
**0.3.** Centrarea datelor
**0.4.** Matricea de covarianță
**0.5.** Valorile și vectorii proprii
**0.6.** Sortarea componentelor
**0.7.** Calculul varianței explicate
**0.8.** Proiecția pe componentele principale
**0.9.** Reducerea dimensionalității
**0.10.** Reconstrucția aproximativă


_C12 PCA.nb_ **19**


**Același exemplu cu o reprezentare grafică simplă**


_O u t [_  _] =_


**[+][ proiecții pe PC1]**


3 ~~.5~~


3 ~~.0~~


2 ~~.5~~


2 ~~.0~~


1 ~~.5~~



X1


|X2|Col2|Col3|Col4|Col5|Col6|P|Col8|
|---|---|---|---|---|---|---|---|
|~~**C**~~**2 (3.7**|**%)**|||||**P**|**P**|
|||||||||
|||||||||
|||||||||
|||||||||
|||||||||
|0.|5<br>1.|0<br>1|.5<br>2.|0<br>2.|5<br>3.|0|0|





**Rezultatul PCA**


Componentele principale (vectorii proprii):




|3<br>2<br>1|Col2|
|---|---|
|-1|1<br>2<br>3|


**20** _C12 PCA.nb_


**Prima componentă** este o linie diagonală ce trece prin norul de puncte.


**A doua componentă** este ortogonală pe prima.


Varianța explicată de:


**PC1** **=** **96.3%**


 Asta înseamnă că aproape întreaga informație (dispersia datelor) se află de-a lungul primei

componente principale.


 Practic, dacă reprezentăm datele doar pe o singură axă (PC₁), pierdem foarte puțină

informație.


**PC2** **=** **3.7%**


 Componenta a doua conține doar  - mică parte din informație (zgomot sau variație

secundară).


 De multe ori se poate ignora, fără pierdere semnificativă.


Aproape toată **informația** ( **dispersia** ) se regăsește pe prima componentă principală.
Proiecția datelor în spațiul PC:






|Obs.|PC<br>1|PC<br>2|
|---|---|---|
|**1**|-1.086|-0.224|
|**2**|2.309|0.178|
|**3**|-1.242|0.502|
|**4**|-0.341|0.170|
|**5**|-2.184|-0.265|
|**6**|-1.161|0.230|
|**7**|0.093|-0.453|
|**8**|1.482|0.056|
|**9**|0.567|0.021|
|**10**|1.563|-0.215|



Tabelul scorurilor PCA (PCA → rotație a sistemului) reprezintă coordonatele observațiilor în
baza ortogonală definită de componentele principale, permițând analiza structurii datelor,
identificarea grupărilor și reducerea dimensională.


_C12 PCA.nb_ **21**


**Interpretarea Rezultatelor PCA**


Eficiența Reducerii Dimensionalității

  - **Captarea Informației** : Prima Componentă Principală (PC₁) reușește să explice aproxima
tiv 96.3% din varianța totală a datelor originale.


  - **Compresia Datelor** : Acest lucru indică faptul că datele inițiale sunt puternic corelate,
permițând reprezentarea lor aproape perfectă într-un spațiu **unidimensional (1D)** fără o
pierdere semnificativă de informație (doar ≈ 3.7% reziduu).


Analiza Componentelor

  - **PC₁** **(Axa Dominantă)** : Prezintă o dispersie ridicată a valorilor (intervalul [-2.18, +2.31]).
Aceasta reprezintă _„coloana vertebrală_ ” a setului de date, surprinzând tendința principală
de variație.


  - **PC2** **(Zgomot/Variație Reziduală)** : Valorile sunt grupate strâns în jurul originii (intervalul

[-0.45, +0.50]). În contextul analizei, această axă conține în principal „ _zgomot_ ” sau detalii
minore care nu contribuie esențial la structura globală.


Proiecția 1D (Vizualizare prin NumberLinePlot)

Reprezentarea pe o singură axă (folosind doar scorurile PC₁) constituie reducerea dimensionalității propriu-zisă:


  - **Păstrarea Distanțelor** : Se observă cum punctele își mențin ierarhia și distanțele relative.
De exemplu, grupările vizibile pe axa PC₁ reflectă densitățile din setul de date original.


  - **Concluzie practică** : Putem înlocui cele două variabile inițiale cu un singur scor (PC₁),
simplificând modelele statistice ulterioare (precum regresia sau clustering-ul) și eliminând
problema multicoliniarității.


Dacă reducem datele la 1D (păstrăm doar PC₁), obținem:







Acest șir de valori este o reprezentare 1D a întregului set de date, care păstrează ≈96%
din informație.


**22** _C12 PCA.nb_

## **Aplicații**


**Compresie de date**


  - **imagini** (compresie și reducerea zgomotului),


  - **audio** (eliminarea componentelor irelevante),


  - **video** (reducerea redundanței spațio-temporale).


**Reducerea dependențelor** liniare (redundanței) dintre variabile


**Preprocesare pentru ML**


  - **reducerea zgomotului** din date,


  - **accelerarea procesului de antrenare**,


  - **diminuarea riscului de supraînvățare** (overfitting).


**Vizualizare în 2D/3D** pentru explorarea și interpretarea datelor


**Bioinformatică**


  - analiza datelor de expresie genetică,


  - clasificarea genelor pe baza tiparelor de expresie.


**Metoda Eigenfaces,** utilizată în recunoașterea facială, aplică PCA pentru a extrage trăsături relevante și a reduce dimensionalitatea imaginilor faciale


**Sisteme de recomandare și procesarea limbajului natural (NLP)**


  - **reducerea dimensionalității datelor** (ex. matrici utilizator–item, reprezentări textuale),


  - **extragerea caracteristicilor latente** și identificarea tiparelor semnificative.


