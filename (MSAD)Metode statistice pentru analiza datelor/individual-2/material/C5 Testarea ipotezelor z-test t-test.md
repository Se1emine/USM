#### **1. Testarea ipotezelor statistice: decizia între H 0 și H 1 folosind testele z și t**

Spre deosebire de estimarea prin intervale de încredere (unde căutăm „unde se află valoarea”), testarea ipotezelor este un **proces judiciar** aplicat datelor: evaluăm dacă dovezile
sunt suficiente pentru a condamna (respinge) o afirmație.


В отличие от интервального оценивания (где мы ищем «где находится значение»),
проверка гипотез представляет собой судебный процесс, применяемый к данным: мы
оцениваем, достаточно ли доказательств, чтобы осудить (отклонить) утверждение.

# ◼ Obiective:


  - **Fundamente** : Înțelegerea logicii de tip „Trial by Data” („Evaluare bazată pe date”).


  - **Mecanisme** : Aplicarea corectă a testelor Z și t.


  - **Interpretare** : Trecerea de la calcule la decizii (p-value, semnificație).


  - **Validitate** : Controlul erorilor și verificarea condițiilor de aplicare.


În contexte reale, cu accent pe


    - **interpretare**,

    - **ipoteze**,

    - **erori**

    - și **validitate** .

_O u t [_  _] =_


|Caracteristică|Interval de Încredere (Tema 4)|Testarea Ipotezelor (Tema 5)|
|---|---|---|
|Întrebare|„Care este valoarea plauzibilă a<br>parametrului?”|„Este valoarea parametrului<br>diferită de X?”|
|Rezultat|Un interval numeric<br>(ex: [65, 75])|O decizie binară<br>(Resping / Nu resping)|
|Perspectivă|Informativă (Precizie)|Decizională (Verdict)|


**2** _C5 Testarea ipotezelor z-test t-test.nb_

# ◼ Logica Decizională sub Incertitudine


În testarea ipotezelor, nu căutăm să confirmăm o teorie, ci acționăm ca un **filtru de proba-**
**bilitate** . Evaluăm dacă datele observate sunt suficient de „ciudate” pentru a abandona
status-quo-ul.


**Definiție** : Testarea ipotezelor este un mecanism de **luare a deciziilor** bazat pe probabilitate și pe un nivel de **risc controlat (α)** .

### **◻ Concepte Fundamentale**

**Ipoteza Nulă (** 𝐻 **0)** : Ipoteza nulă este afirmația de bază despre populație care presupune
**lipsa unui efect, diferențe sau relații** . Ea reprezintă **poziția implicită** („status quo”) pe
care o testăm folosind datele din eșantion.


**Exemple** :


𝐻 **0** : μ = 50 – media populației este 50.


𝐻 **0** : p = 0.5 – proporția populației este 0.5.


𝐻 **0** : μ1 = μ2 – nu există diferență între două medii.

### **Principii ale testării ipotezelor**


**Incompatibilitatea Datelor** : Nu demonstrăm că _H_ 0 este adevărată. Evaluăm doar **cât de**
**incompatibile sunt datele observate cu Ipoteza Nulă** _H_ 0.


**Prezumția de Inocență** : _H_ 0 este întotdeauna considerată adevărată până când dovezile
(datele) suficient de puternice pentru a o respinge.


**Nivelul** **de** **Semnificație** (α): Reprezintă „bugetul de eroare” sau **riscul** pe care ni-l
asumăm de a respinge pe nedrept o ipoteză nulă adevărată (o alarmă falsă, eroare de tip
1).


_C5 Testarea ipotezelor z-test t-test.nb_ **3**


_O u t [_  _] =_

|Regiune|Semnificație|Concluzie Statistică|
|---|---|---|
|**Zona Verde (95%)**|Datele sunt „normale”,<br>compatibile cu hazardul.|Nu respingem H0.<br>Nu avem dovezi pentru o schimbare.|
|**Zonele Roșii (5%)**|Datele sunt „extreme”<br>(probabilitate < α).|Respingem H0.<br>Efectul este statistic semnificativ.|


### **Analogia juridică a testării ipotezelor**


O analogie foarte revelatoare este procesul juridic.


**4** _C5 Testarea ipotezelor z-test t-test.nb_


_O u t [_ _]_


_O u t [_  _] =_

|Статистика|Юридическая система|
|---|---|
|Нулевая гипотеза (H0)|Презумпция невиновности|
|Альтернативная гипотеза (H1)|Обвинение|
|Данные выборки|Доказательства в судебном процессе|
|Уровень значимости (α)|Стандарт доказательства («вне разумного сомнения»)|
|Отклонить H0|Вердикт: виновен|
|Не отклонять H0|Вердикт: невиновен (но невиновность не доказана)|


|Statistică|Sistem juridic|
|---|---|
|Ipoteza nulă (H0)|Prezumția de nevinovăție|
|Ipoteza alternativă (H1)|Acuzația|
|Datele din eșantion|Dovezile din proces|
|Nivelul de semnificație (α)|Standardul de probă („dincolo de orice îndoială rezonabilă”)|
|Respinge H0|Verdict: vinovat|
|Nu respinge H0|Verdict: nevinovat (dar nu demonstrat nevinovat)|



Interpretarea corectă


  - _H_ 0 este ipoteza implicită: _„nu există efect sau diferență”_ .


  - Analizăm datele pentru a vedea dacă există **dovezi suficient de puternice** împotriva lui

_H_ 0.


  - Dacă dovezile sunt suficient de puternice → **respingem** _H_ 0.


  - Dacă dovezile nu sunt suficiente → **nu respingem** _H_ 0.


Important:


Nu respingem _H_ 0 ≠ demonstrăm că _H_ 0 este adevărată


Exact ca în justiție:


Un verdict de **„nevinovat** ” nu înseamnă că persoana este demonstrată nevinovată, ci doar
că **dovezile nu au fost suficiente pentru condamnare** .

### **Fluxul testării ipotezelor statistice**


Testarea ipotezelor nu încearcă să **demonstreze adevărul**, ci să determine dacă **datele**
**sunt suficient de incompatibile cu ipoteza nulă** pentru a o respinge.


_C5 Testarea ipotezelor z-test t-test.nb_ **5**














**6** _C5 Testarea ipotezelor z-test t-test.nb_

#### **2. Motivație și context: De la Descriere la Decizie**


Testarea ipotezelor nu este doar un calcul, ci „motorul” care transformă datele brute în
concluzii științifice. Este trecerea de la întrebarea „ _Ce s-a întâmplat?_ ” la întrebarea „ _Ce_
_înseamnă asta pentru viitor?_ ”.

# ◼ De ce este necesară testarea ipotezelor?

### ◻ Legătura cu:

   - **Tema 2 (Statistici Descriptive)** : Ne-au ajutat să vedem „fața” datelor (medie, dispersie). Dar o medie mare în eșantion este un efect real sau doar noroc?

   - **Tema 4 (Estimare și IC)** : Ne-au arătat „unde” s-ar putea afla parametrul. Dar este
acest parametru semnificativ diferit de o valoare de referință?

   - **Tema 5 (Testarea Ipotezelor)** : Ne oferă verdictul. Trecem de la explorare la validare
formală.
### **◻ Decizia statistică vs. certitudine absolută (Статистическое решение** **vs. абсолютная достоверность)**


În științele aplicate, certitudinea de 100% nu există. Lucrăm întotdeauna cu probabilități.


Pentru a înțelege de ce apelăm la instrumente statistice complexe, trebuie să acceptăm
distincția fundamentală dintre idealul certitudinii și realitatea deciziei bazate pe date, așa
cum este sintetizată în tabelul următor:”


_O u t [_  _] =_


|Concept|Abordare|
|---|---|
|**Certitudinea**<br>**достоверность**|Imposibilă (ar necesita testarea întregii populații).|
|**Decizia Statistică**<br>**Статистическое решение**|Singura cale rațională: acceptăm un risc controlat (α)<br>pentru a lua o decizie.|
|**Incertitudinea**<br>**Неопределённость**|Nu este un defect, ci o componentă măsurabilă<br>a modelului nostru.|


_C5 Testarea ipotezelor z-test t-test.nb_ **7**

# ◼ Mesaj-cheie (Ключевая идея):


   - Testarea ipotezelor este un **mecanism formal de decizie sub incertitudine** . Ea ne
protejează de intuiția umană care tinde să vadă tipare și „descoperiri” acolo unde
există doar hazard (случайность).

   - Exemplu de ancorare:

     - Dacă un medicament nou scade tensiunea cu 5 unități mai mult decât cel vechi
într-un grup de 20 de persoane, este o revoluție medicală sau o simplă fluctuație
de eșantionare? Testarea ipotezelor ne dă răspunsul.

     - Fără testarea ipotezelor, am putea lansa pe piață medicamente inutile doar pentru
că am avut ‘noroc’ de un eșantion favorabil. Statistica este ‘filtrul’ care ne separă
speranțele de realitatea obiectivă.”


**8** _C5 Testarea ipotezelor z-test t-test.nb_

#### **3. Protocolul decizional al testării ipotezelor: 4 piloni**


Testarea ipotezelor este un protocol riguros în 4 piloni, care ne permite să trecem de la
date la decizie.

# ◼ 1. Duelul Ipotezelor ( H 0 vs. H 1)

     - Ipoteza nulă 𝐻0: Afirmația de referință (Status Quo). Presupunem că nu există niciun efect sau nicio diferență.

( _H_ 0 : μ = μ0)

   - Ipoteza alternativă 𝐻1: Ceea ce cercetătorul încearcă să demonstreze.

     - bilaterală: _H_ 1 : μ ≠μ0, există o diferență, indiferent de direcție.

     - unilaterală dreapta: _H_ 1 : μ     - μ0, ne interesează o direcție specifică (ex: medicamen
tul mărește tensiunea).

     - unilaterală stânga: _H_ 1 : μ < μ0, ne interesează o direcție specifică (ex: medicamentul scade tensiunea).

Mesaj-cheie:


   - Tipul ipotezei alternative determină regiunea critică și regula de decizie a testului. Prin
urmare dictează unde plasăm „capcanele” (regiunea critică) pe graficul distribuției.

# ◼ 2. Instrumentele Decizionale


   - **Statistica de Test:**

     - Un „scor” calculat din date (Z sau t). Sub _H_ 0, știm exact cum ar trebui să arate
acest scor (Distribuția Nulă).

   - **Nivelul de Semnificație (α)** :

     - Riscul maxim de „alarmă falsă” pe care ni-l asumăm (de obicei 0.05).

# ◼ 3. Valoarea-p (p-value): Indicatorul Probei (indice al surpizei, индекс неожиданности)


Este „greutatea” dovezilor împotriva _H_ 0.

     - Definiție: Valoarea-p este probabilitatea, sub ipoteza nulă _H_ 0, de a obține o valoare a statisticii de test cel puțin la fel de

extremă ca cea observată.

Deși valoarea-p este instrumentul central de decizie, interpretarea ei este adesea presărată
cu erori conceptuale. Pentru a evita capcanele clasice, trebuie să clarificăm ce informații
NU ne oferă acest indicator:


_C5 Testarea ipotezelor z-test t-test.nb_ **9**


_O u t [_ _]_



|Ce NU este Valoarea-p|Explicație|
|---|---|
|**Nu este P(H0 adevărată)**|Nu ne spune dacă ipoteza este adevărată,<br>ci cât de „ciudate” (incompatibile) sunt datele<br>observate cu acea ipoteză.|
|**Nu este importanța practică**|Un efect poate fi semnificativ statistic (p < 0.05),<br>dar poate fi atât de mic încât să fie<br>irelevant în contextul real (clinic, economic etc.).|



- Ce NU este valoarea-p






     - nu este probabilitatea ca 𝐻0 să fie adevărată

     - nu măsoară importanța practică a rezultatului


   - Regula de decizie:

     - dacă 𝑝 ≤ 𝛼 → respingem 𝐻0

     - dacă 𝑝 > 𝛼 → nu respingem 𝐻0


**Regula lui Fisher:** _Dacă p este mic, fie s-a întâmplat ceva foarte rar, fie ipoteza nulă este_
_falsă._


În știință, operăm conform principiului parsimoniei (Briciul lui Occam). Deși teoretic este
posibil ca _H_ 0 să fie adevărată și noi să fi observat o coincidență de 1 la 1000, este mult mai
plauzibil să admitem că presupunerea noastră inițială ( _H_ 0) a fost greșită. Valoarea-p mică
ne dă permisiunea statistică de a favoriza explicația cea mai probabilă: existența unui efect
real.


**Briciul lui Occam** (sau Lex Parsimoniae) este un principiu filosofic și științific care spune
că, atunci când ai mai multe explicații posibile pentru același fenomen, **cea mai simplă**
**explicație este, de obicei, cea corectă.**

# ◼ 4. Regula deciziei statistice (Decizia finală)


Aplicarea criteriului:

 - dacă 𝑝 ≤ 𝛼 → respingem 𝐻0

 - dacă 𝑝 > 𝛼 → nu respingem 𝐻0


Acest pilon transformă evidența statistică în decizie formală.


**10** _C5 Testarea ipotezelor z-test t-test.nb_

# ◼ Diagrama unificatoare






















_C5 Testarea ipotezelor z-test t-test.nb_ **11**

#### **4. Erori statistice și puterea testului**


_În statistică, nu căutăm certitudinea, ci_ _**controlăm probabilitatea de a greși**_ _._


Nici o decizie bazată pe eșantion nu este 100% sigură.


În testarea ipotezelor, gestionăm riscul prin controlul erorilor statistice.

# ◼ Testarea ipotezelor ca sistem de detecție binar


Interpretăm testul ipotezelor ca pe un radar care încearcă să distingă un semnal real de
zgomotul de fond:


  - **0 (off)** → Zgomot / Absență efect ( _H_ 0 este adevărată)


  - **1 (on)** → Semnal / Efect detectat ( _H_ 1 este adevărată)



_O u t [_  _] =_

|Col1|Col2|Col3|Col4|Col5|
|---|---|---|---|---|
||**Matrice decizie–realitate**|**Stare reală: H0**<br>**(Absență efect)**|**Stare reală: H1**<br>**(Prezență efect)**||
||**Decizie: 0**<br>**(Nu respingem H0)**<br>**(Test negativ)**|Adevărat negativ (TN)<br>Decizie corectă<br>P = 1 −α|Fals negativ (FN)<br>Eroare de Tip II (β)<br>P = β||
||**Decizie: 1**<br>**(Respingem H0)**<br>**(Test pozitiv)**|Fals pozitiv (FP)<br>Eroare de Tip I (α)<br>P = α|Adevărat pozitiv (TP)<br>Puterea testului<br>P = 1 −β||
||||||



_O u t [_  _] =_




- **Verdictul** : Decizie **Pozitivă** (Respingem _H_ 0) vs. Decizie **Negativă** (Eșuăm în a respinge

_H_ 0).
















|Col1|Col2|Col3|Col4|Col5|
|---|---|---|---|---|
||**Матрица: решение–реальность**|**Реальное состояние: H0**<br>**(Отсутствие эффекта)**<br>|**Реальное состояние: H1**<br>**(Наличие эффекта)**<br>||
||**Решение: 0**<br>**(Не отвергаем H0)**<br>**(Отрицательный тест)**|Истинно отрицательный<br>результат (TN)<br>Правильное решение<br>P = 1 −α<br>|Ложно отрицательный<br>результат (FN)<br>Ошибка II рода (β)<br>P = β<br>||
||**Решение: 1**<br>**(Отвергаем H0)**<br>**(Положительный тест)**|<br>Ложно положительный<br>результат (FP)<br>Ошибка I рода (α)<br>P = α|<br>Истинно положительный<br>результат (TP)<br>Мощность теста<br>P = 1 −β||
||||||



În contextul testării ipotezelor, “Pozitiv” înseamnă că am detectat ceva (am respins _H_ 0), iar
“Negativ” înseamnă că nu am găsit nimic (nu am respins _H_ 0).


**12** _C5 Testarea ipotezelor z-test t-test.nb_

### **◻ Ipoteze și analogia medicală**


_H_ 0: persoana este sănătoasă (nu există boală / efect)).


_H_ 1: persoana este bolnavă (există boală / efect).


Decizia de a NU respinge _H_ 0 (când _H_ 0 e adevărată) este un Adevărat Negativ (nu am găsit
boala și ea chiar nu există).


Decizia de a Respinge _H_ 0 (când _H_ 0 e falsă) este un Adevărat Pozitiv (am găsit boala și ea
chiar există).


_O u t [_  _] =_


_O u t [_  _] =_

|Ситуация<br>(Реальность и решение)|Статистическая<br>интерпретация|Тип результата|
|---|---|---|
|Не отвергаем H0 и H0 истинна|Правильное решение<br>(специфичность)|**Истинно отрицательный**<br>**результат (TN)**|
|Отвергаем H0 и H1 истинна|Правильное решение<br>(мощность теста)|**Истинно положительный**<br>**результат (TP)**|
|Отвергаем H0 и H0 истинна|Ошибка I рода (α)|**Ложно положительный**<br>**результат (FP)**|
|Не отвергаем H0 и H1 истинна|Ошибка II рода (β)|**Ложно отрицательный**<br>**результат (FN)**|


|Situație (Realitate & Decizie)|Interpretare Statistică|Tip Rezultat|
|---|---|---|
|Nu respingem H0 & H0 adevărată|Decizie Corectă (Specificitate)|**Adevărat Negativ (TN)**|
|Respingem H0 & H1 adevărată|Decizie Corectă (Puterea Testului)|**Adevărat Pozitiv (TP)**|
|Respingem H0 & H0 adevărată|Eroare de Tip I (α)|**Fals Pozitiv (FP)**|
|Nu respingem H0 & H1 adevărată|Eroare de Tip II (β)|**Fals Negativ (FN)**|


# ◼ Tipuri de erori


     - Eroare de tip I (α): respingem _H_ 0 deși este adevărată → fals pozitiv, probabilitate = α

     - Eroare de tip II (β): nu respingem _H_ 0 deși este falsă → fals negativ, probabilitate = β


_C5 Testarea ipotezelor z-test t-test.nb_ **13**

# ◼ Puterea testului


Reprezintă capacitatea testului de a detecta un efect atunci când acesta există cu adevărat.


Puterea = 1−β = probabilitatea de a detecta corect un efect real


     - Concept intuitiv:


       - puterea testului este probabilitatea de a respinge corect ipoteza nulă atunci când ea este falsă


     - Factori care o influențează:


       - dimensiunea eșantionului


       - variabilitatea datelor


       - nivelul de semnificație α


Cum „ascuțim” radarul (creștem Puterea)?


Mă **rim eșantionul (n ↑)** : Mai multe date reduc incertitudinea.


**Reducem variabilitatea** : Date mai precise (zgomot mai mic).


**Alegem un α** **mai relaxat** : Există un compromis; dacă scădem riscul de Fals Pozitiv (α),
creștem riscul de Fals Negativ (β).


**14** _C5 Testarea ipotezelor z-test t-test.nb_

#### **5. z-test pentru medie: Protocolul Standard**


Z-testul este „standardul de aur” atunci când avem informații complete despre populație
sau un eșantion suficient de robust.

# ◼ 1. Condiții de Validitate (Checklist)


Înainte de a calcula, verificăm dacă datele permit utilizarea distribuției Normale:


  - **Varianța cunoscută** : Știm σ [2] din studii anterioare sau date istorice.


  - **Volumul eșantionului** : n ≥ 30 (permite utilizarea Teoremei Limitei Centrale chiar dacă

populația nu este normală).


  - **Independența** : Datele au fost colectate aleatoriu.


     - **Varianța cunoscută:** știm varianța populației σ [2] din studii anterioare sau date istorice

     - **Volumul eșantionului:** 𝑛 ≥ 30 (permite utilizarea Teoremei Limitei Centrale chiar dacă populația este normală).

     - **Independența** : Datele au fost colectate aleatoriu.

# ◼ 2. Mecanismul de Calcul: Statistica de Test


Statistica Z cuantifică distanța, exprimată în număr de erori standard, dintre media eșantionului 𝑥 și media ipotetică μ0.



_Z_ calc =



_x_ - μ0


σ






 - **Numărător** : Diferența brută (Efectul observat).


 - **Numitor** : Eroarea Standard ( _SE_ ) — „zgomotul” de eșantionare.

# ◼ 3. Procedura Pas cu Pas (Algoritmul Decizional)


   - 1. Formularea ipotezelor


   - 2. Alegerea lui α


   - 3. Calculul statisticii de test


   - 4. Determinarea valorii-p / regiunii critice


   - 5. Decizia și interpretarea


_C5 Testarea ipotezelor z-test t-test.nb_ **15**


_O u t [_ _]_

|Col1|Col2|Col3|Col4|Col5|
|---|---|---|---|---|
||**as**|**Acțiune**|**Explicație**||
||**1**|**Ipoteze**|Stabilim H0: μ = μ0 și H1: μ ≠μ0 (sau unilateral).||
||**2**|**Pragul α**|Alegem riscul (de obicei 0.05). Fixăm „linia în nisip”.||
||**3**|**Calcul Z**|Aplicăm formula de mai sus pe datele noastre.||
||**4**|**P-value / Critic**|Comparăm Zcalc cu valorile critice din tabela Normală (1.96 pentru 0.05).||
||**5**|**Decizia**|p ≤α ⟹Respingem H0. Rezultat semnificativ.||
||||||



**Scorul** _Z_ **(Locația)** : Ne spune unde se află media noastră pe harta distribuției normale. (ex:
“Suntem la 2.5 deviații standard distanță”).


**Valoarea** _p_ **(Probabilitatea)** : Ne spune cât de rar este să ajungi acolo prin simplu noroc.
(ex: “Probabilitatea de a fi atât de departe este de 0.012”).


**Echivalența** :


  - Dacă _Z_ calc trece de pragul “fizic” (ex: 1.96), atunci automat aria de dincolo de el ( _p_ ) va fi

mai mică decât pragul de “arie” acceptat (α = 0.05).


  - **Respingem** _H_ 0 **dacă** : Scorul e prea mare (Z > 1.96) SAU probabilitatea e prea mică (p <

0.05).


**Digitalizarea Testului Z**


În trecut: Căutam în tabele imprimate. Astăzi: Folosim InverseCDF pentru praguri sau
funcția directă ZTest. Spre exemplu, dacă am calculat un _Z_ = 2.15, putem obține valoarea
_p_ pentru un test bilaterial imediat:









Deoarece p = 0.0315552 < 0.05  respingem _H_ 0.


**16** _C5 Testarea ipotezelor z-test t-test.nb_

#### **6. T-Test pentru Medie (Distribuția Student)**


Când eșantionul este mic sau varianța populației este un mister, apelăm la t.

# ◼ 1. De ce t și nu z? (Motivele Tranziției)


Z-testul este prea „optimist” pentru eșantioane mici. T-testul este mai prudent deoarece:


     - **Varianța populației (σ) este necunoscută** : Suntem obligați să folosim varianța eșantionului  _s_ [2]  ca o estimare.


     - **Incertitudinea eșantioanelor mici** : Când _n_ este mic, eroarea de estimare a lui _s_ este mare. Distribuția _t_ compensează

acest risc.

# ◼ 2. Anatomia Distribuției Student


Distribuția _t_ seamănă cu cea Normală, dar are „cozi mai grele” (probabilitate mai mare
pentru valori extreme).


     - **Grade de libertate** : ν = n -1 (parametrul care definește forma curbei)


     - **Proprietate** : pe măsură ce _n_ crește (n ⟶ ∞), distribuția _t_ devine identică cu distribuția Normală _Z_ .

# ◼ 3. Statistica de Test: Formula


Structura rămâne identică cu cea de la _Z_, dar înlocuim parametrul populației (σ) cu cel al
eșantionului (s):



_t_ calc =



_x_ - μ0

_s_












### **◻ Regula de aur**

 - **Știi** σ? Folosești **Z** .


_C5 Testarea ipotezelor z-test t-test.nb_ **17**


  - **Nu știi** σ (cazul general)? Folosești **T** .


  - **Ai** n > 30? Chiar dacă folosești T, rezultatul va fi aproape identic cu Z (T-testul este

robust).


**18** _C5 Testarea ipotezelor z-test t-test.nb_

#### **7. Variante ale Testului T: Cum alegem testul corect?**


Alegerea testului depinde exclusiv de structura datelor și de numărul grupurilor comparate.

# ◼ 1. One-Sample T-Test (Un singur eșantion)


     - **Scop** : Comparăm media unui grup cu o valoare de referință cunoscută (ex: media istorică, un standard de calitate).


     - **Exemplu** : „Este media înălțimii studenților de anul I diferită de media națională de 175 cm?”

     - **Ipoteza** : _H_ 0 : μ = μref

# ◼ 2. Independent Two-Sample T-Test (Eșantioane independente)


     - **Scop** : Comparăm mediile a două grupuri complet diferite.


     - **Nuanță (Varianțe)** :


       - **Testul T standard** : Presupune varianțe egale (omogenitate).


       - Tes **tul Welch** : Se folosește când varianțele celor două grupuri sunt semnificativ diferite (mai robust).


     - **Exemplu** : „Există o diferență de tensiune între grupul care a primit medicamentul A și grupul care a primit un Placebo?”

# ◼ 3. Paired T-Test (Date pereche / Măsurători repetate)


     - **Scop** : Comparăm două medii provenite de la **aceiași subiecți**, măsurați în momente diferite.


     - **Exemplu** : „Tensiunea arterială înainte de tratament vs. tensiunea **după** 4 săptămâni de tratament (pe același pacient).”


     - **Avantaj** : Elimină variabilitatea dintre indivizi, fiind mult mai sensibil (putere statistică mai mare).

# ◼ 4. Podul logic: Testul de Ipoteză ↔ Intervalul de Încredere (IC)


Există o dualitate perfectă între cele două metode. Pentru un nivel α = 0.05:


     - Pentru in nivel de semnificație α ipoteza nulă _H_ 0 : μ = μ0 este respinsă dacă și numai dacă valoarea ipotetică μ0 nu
aparține intervalului de încredere de nivel 1 - α.
_O u t [_  _] =_


|Col1|Col2|Col3|Col4|Col5|
|---|---|---|---|---|
||**est**|**Funcție Mathematica**|**Funcție Python (SciPy)**||
||**ntion**|TTest[data, μ0]|stats.ttest_1samp(data, mu0||
||**dente**|TTest[{d1, d2}]|stats.ttest_ind(d1, d2)||
||**che**|TTest[d1, d2]|stats.ttest_rel(d1, d2)||
||||||


_C5 Testarea ipotezelor z-test t-test.nb_ **19**

#### **8. Activități de laborator (esențiale)**


Scopul laboratorului este validarea intuiției prin calcul numeric și simulare.

# ◼ 1. Wolfram Mathematica: Analiză Vizuală și Simbolică


     - **Simulare & Formă** : Generarea distribuțiilor Z vs. t pentru a observa „cozile grele” ale distribuției Student la eșantioane

mici (n < 10).

     - **Dualitatea Calculului:**


**◼** _Manual_ : Utilizarea InverseCDF și CDF pentru a găsi pragurile critice.


**◼** _Automat_ : Utilizarea TTest și ZTest pentru obținerea raportului complet (“FullReport”).


     - **Geometria Deciziei** : Vizualizarea zonelor de respingere (hașurarea regiunilor critice) pentru teste mono și bi-laterale.

# ◼ 2. Python (Jupyter): Pipeline-ul de Data Science


Vom implementa fluxul complet folosind biblioteca scipy.stats:


     - Explorare: Verificarea normalității datelor (Histogramă + shapiro test).


     - Execuție:


       - ztest: Pentru eșantioane mari. scipy.stats.ztest


       - ttest_1samp: Verificarea unei medii față de un standard. scipy.stats.ttest_1samp


       - ttest_ind: Compararea a două grupuri (cu opțiunea equal_var=False). scipy.stats.ttest_ind


       - ttest_rel: Analiza experimentelor de tip „Înainte vs. După”. scipy.stats.ttest_rel


     - **Interpretare** : Extragerea atributelor .statistic și .pvalue din obiectul returnat.

# ◼ 3. Sinteză Conceptuală Finală


  - **Alegerea** **testului** : Depinde de mărimea eșantionului și de design (independent vs.

pereche).


  - **Contextul** : Un test semnificativ (p < 0.05) trebuie interpretat întotdeauna împreună cu
Intervalul de Încredere.


  - **Raportare** : Nu scriem doar „respingem _H_ 0, ci „există dovezi statistice suficiente pentru a

susține că...”.


**20** _C5 Testarea ipotezelor z-test t-test.nb_

#### **9. Sinteză conceptuală**

# ◼ 1. Arborele de Decizie: Alegerea corectă a testului


Nu reținem formule, ci învățăm să punem întrebările corecte datelor:


  - **Câte grupuri avem?** (Unul singur vs. Două grupuri).


  - **Sunt grupurile independente?** (Oameni diferiți vs. Aceiași oameni măsurați de două ori).


  - **Cunoaștem varianța populației (σ)?**


     - **DA**  **Z-Test** (Cazul ideal).


     - **NU**  **T-Test** (Cazul realist).

# ◼ 2. Rolul Ipotezelor și Contextul


Statistica nu este doar despre numere, ci despre povara dovezii:


  - _**H**_ **0** **(Nula)** : Este „prezumția de nevinovăție”. Nu acceptăm   - schimbare decât dacă

dovezile sunt copleșitoare (p ≤ 0.05).


  - **Contextul contează** : Un rezultat semnificativ statistic (p < 0.05) nu înseamnă întot
deauna un rezultat important în realitate. Întrebați-vă mereu: _„Este această_ _diferență_
_relevantă pentru un medic sau un inginer?_ ”

# ◼ 3. „Podul” către Intervalele de Încredere (IC)


Cele două concepte sunt fețele aceleiași monede:


  - **Testul de ipoteză** : Ne dă un verdict binat (Da/Nu, Respingem/Nu respingem).


  - **Intervalul de Încredere** : Ne oferă o gamă de valori plauzibile pentru media reală.


  - **Sinergia** : Dacă IC de 95% pentru diferența dintre două grupuri conține valoarea 0, atunci

testul T va returna un p > 0.05 (nu există diferență semnificativă).

# ◼ 4. „Take-away” pentru examen:


  - **P-value mic (< 0.05)**  Datele sunt incompatibile cu liniștea lui _H_ 0; ceva se întâmplă!


  - **Eroarea de Tip I** (α)  Să nu fim „alarmiști” (nu vedem efecte acolo unde nu sunt).


  - **Puterea testului (1-β)**  Să nu fim „orbi” (să avem un eșantion destul de mare ca să nu
ratăm efectele reale).


_C5 Testarea ipotezelor z-test t-test.nb_ **21**

#### **Setări**

# **◼ Setări notebook** **◼ Setări celule**


