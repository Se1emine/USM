# **Liniar Regression**

_**Presenter**_


**Valeriu Ungureanu**


_**Data**_


_**Friday, 20 March 2026**_


_**Moldova State University**_


_Statistical Methods for Data Analysis_


**2** _C8 Regresia liniara.nb_

##### **1. Inițiere în Regresia Liniară**

## ◼ Obiective


La finalul acestei unități, vom fi capabili să:


   - Înțelegem specificul învățării automate în metodele statistice de analiză a datelor

   - Analizăm relațiile de corelație

     - între două variabile

     - între una și un set de variabile

   - Construim, interpretăm și aplicăm modelul de regresie liniară

## ◼ Ce este Machine Learning?


Să începem cu niște întrebări simple:


Ce este **Machine Learning** /Învățarea Automată/Învățarea Statistică?


Care sunt **atributele de bază** ale învățării automate?


De ce învățarea automată acumulează atât de multă atenție în ultimii ani?


Învățarea automată este de fapt un domeniu relativ vechi, fiind domeniu de studiu în decurs
de multe decenii.


Denumirea de „ **machine learning** " a fost propusă de **Arthur Samuel**, un informatician
american care a lucrat la IBM. Samuel a folosit această denumire pentru prima dată în
**1959**, într - un articol intitulat „ _Some Studies in Machine Learning Using the Game of_
_Checkers_ ".


În articolul său, Samuel a folosit termenul „machine learning" ca fiind „ _abilitatea unui sistem_
_de a învăța fără a fi explicit programat_ ". Chiar dacă descrierea este luată în ghilimele, ea nu
este un citat din articolul menționat, ci mai degrabă o descriere a ceea ce subînțelege
autorul prin acest termen. El a dat ca exemplu jocul de dame (шашки), în care un computer
poate învăța să joace prin analizarea unui set de date de jocuri jucate de jucători umani.


Termenul de „ **machine learning** " a devenit rapid popular în domeniul inteligenței artificiale.
Astăzi, este folosit în mod obișnuit pentru a se referi la orice metodă de învățare automată
care nu necesită programare explicită și se bazează pe date și modele.


Ca disciplină, disciplina poate fi privită în timp ca dezvoltându-se concomitent în diferite
domenii și direcții, ca să converagă recent într-un domeniu comun - machine learning. Din
acest punct de vedere, uneori se utilizează și alte denumiri:


_C8 Regresia liniara.nb_ **3**


  - Inductive inference;


  - Inductive learning;


  - Statistical learning;


  - Pattern recognition;


  - Data mining;


  - Learning machines.


Ceea ce **au în comun** toate aceste discipline este că **procesează date**, **dezvoltă modele**
**adaptabile la date** și, ulterior, **fac predicții** care pot duce la **decizii** . Termenul de „ _machine_
_learning_ " a devenit actualment dominant grație dezvoltării resurselor informaționale: calculatoare puternine, rețele de comunicare și seturi de date foarte mari.


Menține actualmente o atenție deosebită prin performanța cu care îndeplinește o serie de
sarcini dificile, importante și foarte interesante. O perspectivă destul de sugestivă asupra
machine learning este cea legată de faptul că machine learning în particular, și inteligența
artificială, în general, marchează începutul celei de-a patra revoluții industriale. Să le reamintim pe toate:


  - I-ma revoluție industrială - sfârșitul secolului XVIII. Apare în Anglia și e marcată de

apariția **producției industriale bine organizate**, bazată pe **motoarele cu aburi** .


  - A II-a revoluție industrială - sfârșitul secolului XIX - începutul secolului XX. E marcată de

utilizarea electricității în **producția industrială de masă**, bazată pe **motoare electrice** .


  - A III-a revoluție industrială - mijlocul secolului XX. Este marcată de utilizarea pe larg a

electronicii, calculatoarelor, tehnologiilor informaționale și producției industriale automatizate. Am putea spune totuși că se referă mai mult la efectuarea **lucrului manual** de către
calculatoare în baza **tehnologiilor informaționale** .


  - A IV-a revoluție industrială, care abia se conturează - începutul anilor 20 ai secolului XXI.
Efectuarea **lucrului intelectual** de către inteligența artificială și **convergența** câtorva
direcții: **fizică, digitală și biologică** .


În învățarea automată sunt evidențiate câteva domenii mai importante de studii și aplicații:


**4** _C8 Regresia liniara.nb_




























_C8 Regresia liniara.nb_ **5**










#### ◻ Învățarea supervizată:

în această ramură, modelul de învățare automată este antrenat pe un set de date care
conține atât exemple de input, cât și exemple de output dorite. Modelul învață să genereze
output - ul dorit pentru orice input nou. Datele, in general, reprezinta o consecutivitate de
perechi de caracteristici ale unui obiect si eticheta corespunzatoare, adica le putem
reprezenta formal astfel:


_x_ [1] = ( _x_ 11, _x_ 12, ..., _x_ 1 _n_ ) _[T]_ ⟶ _y_ 1
_x_ [2] = ( _x_ 21, _x_ 22, ..., _x_ 2 _n_ ) _[T]_ ⟶ _y_ 2

...
_x_ _[m]_ = ( _x_ m1, _x_ m2, ..., _x_ mn) _[T]_ ⟶ _ym_


În principiu, în învățarea supervizată se pune problem determinării în baza datelor a unei
funcții _y_ = _f_ ( _x_ ) : _R_ _[n]_ ⟶ _R_ care ar putea prognoza în baza datelor noi de intrare _x_, ieșirea
corespunzătoare cu o doză cât mai mare de adevăr.

#### ◻ Învățarea nesupervizată:


în această ramură, modelul de învățare automată este antrenat pe un set de date care
conține doar exemple de input. Modelul învață să identifice modele în datele de input, fără
a avea acces la output - ul dorit. În acest domeniu datele reprezintă o succesiune de seturi
de caracteristici ale diverse obiecte, adică datele reprezintă o succesiune de vectori:


_x_ [1] = ( _x_ 11, _x_ 12, ..., _x_ 1 _n_ ) _[T]_

_x_ [2] = ( _x_ 21, _x_ 22, ..., _x_ 2 _n_ ) _[T]_

...
_x_ _[m]_ = ( _x_ m1, _x_ m2, ..., _x_ mn) _[T]_

#### ◻ Învățarea semisupervizată:


în această ramură, modelul de învățare automată este antrenat pe un set de date care
conține o combinație de exemple de input și exemple de output dorite. Acest lucru permite
modelului să învețe atât de la exemplele de input, cât și de la exemplele de output dorite.


**6** _C8 Regresia liniara.nb_

#### ◻ Învățarea prin consolidare (întărire/armare, recompensă, încurajare; обучение с подкреплением, обучение поощрением):


este un tip de învățare automată în care agentul învață să ia decizii care îi maximizează
recompensa. Agentul este recompensat pentru comportamentele care îl duc la un rezultat
dorit și pedepsit pentru comportamentele care îl duc la un rezultat nedorit (învățare prin
probe/încercări și erori). De - a lungul timpului, agentul învață să ia decizii care îi aduc
recompense maxime.


Un exemplu simplu de învățare prin întărire este un robot care învață să evite obstacolele.
Robotul este recompensat atunci când se deplasează prin spațiu fără să se lovească de un
obstacol și pedepsit atunci când se lovește de un obstacol. De - a lungul timpului, robotul
învață să se deplaseze prin spațiu evitând obstacolele.


Învățarea prin recompensă este utilizată în multe domenii, inclusiv :


**Jocuri** : Învățarea prin recompensă este utilizată pentru a antrena agenți care să joace
jocuri complexe, cum ar fi șah, go sau poker.
**Autonomie** : Învățarea prin recompensă este utilizată pentru a antrena agenți autonomi,
cum ar fi mașini autonome sau drone.
**Optimizare** : Învățarea prin recompensă este utilizată pentru a rezolva probleme de optimizare, cum ar fi găsirea celui mai scurt drum între două puncte.


Învățarea prin recompensă este o tehnică puternică care poate fi utilizată pentru a învăța
agenți să ia decizii complexe în medii dinamice.


_C8 Regresia liniara.nb_ **7**

##### **2. Analiza Corelației și Regresiei Liniare**


Pentru a înțelege regresia liniară, vom aborda conceptele într-o **succesiune logică** : fiecare
nivel se bazează pe cel anterior. Pornim de la modul în care variabilele evoluează împreună și ajungem la **modelarea** și **predicția** acestora.

## ◼ 1. Covarianța — direcția relației


Covarianța măsoară modul în care două variabile aleatoare _X_ și _Y_ variază simultan.



cov( _X_, _Y_ ) =



∑ _ni_ =1 ( _xi_ - _x_ ) ( _yi_ - _y_ )

_n_    - 1




 - cov( _X_, _Y_ ) > 0 → relație directă (variabilele cresc împreună)


 - cov( _X_, _Y_ ) < 0 → relație inversă


 - cov( _X_, _Y_ ) ≈ 0 → absența unei relații liniare evidente


**Limitare** : depinde de unitățile de măsură → nu permite comparații standardizate.

## ◼ 2. Coeficientul de Corelație Pearson (r) — intensitatea relației


Corelația standardizează covarianța, eliminând dependența de unități. Ea elimină unitățile
de măsură și ne oferă un indicator fix între -1 și +1.



_r_ =


- r = 1 → corelație liniară pozitivă perfectă



cov( _X_, _Y_ )

_sX sY_




- r = -1 → corelație liniară negativă perfectă


- r = 0 → lipsa corelației liniare







**Interpretare** : măsoară forța și direcția relației.


Dacă înlocuim aceste expresii în formula pentru r, atunci, după simplificări obținem:


**8** _C8 Regresia liniara.nb_



_r_ =





∑ _ni_ =1 ( _xi_ - _x_ ) ( _yi_ - _y_ )


## ◼ 3. Regresia liniară simplă — modelarea și predicția

Regresia liniară oferă modelul matematic explicit al relației dintre variabile.


Ecuația liniei este:


Y = β0 + β1 _X_ + ϵ


 - β0 ( **intercept** ): valoarea lui Y pentru X = 0


 - β1 ( **pantă** ): variația medie a lui Y la o unitate din X


 - ϵ ( **eroare** ): componenta neexplicată de model


**Obiectiv** : determinarea liniei de regresie optime (best fit).


_C8 Regresia liniara.nb_ **9**


Out[6]










|Col1|5|Col3|Col4|
|---|---|---|---|
|||||
|~~**Y2.0**~~<br>**β1 = ΔY/ΔX**<br>0<br>-|5<br>~~5~~||5<br>1|
|ΔX=2<br>~~**Δ=**~~|~~10~~<br>~~-~~|**Teo**<br>β0=3 |<br>~~**Es**~~|**rie (β)**<br>  β1=1.0<br>~~**imat (b)**~~|








## ◼ 4. Coeficientul de Determinare R [2] — calitatea modelului

Coeficientul _R_ [2] cuantifică performanța modelului:


_R_ [2] = _r_ [2]


 - exprimă **proporția din variația lui** Y **explicată de** X


 - valori în intervalul [0, 1]


**Exemplu** : dacă r = 0.8, atunci R² = 0.64 → modelul explică 64% din variația lui Y


**Formulare corectă** : _R² indică variația explicată_, nu „cauzalitatea”.

## **◼ 5. Rezumat vizual al legăturii dintre concepte**


Următorul tabel scoate în evidență progresia conceptuală:


**10** _C8 Regresia liniara.nb_


Direcție → Intensitate → Model → Evaluare


_O u t [_  _] =_

|Concept|Întrebare cheie|Rol|
|---|---|---|
|**Covarianță**|Se mișcă variabilele împreună?|Direcție|
|**Corelație (r)**|Cât de puternică este relația liniară?|Intensitate|
|**Regresie**|Care este modelul<br>matematic al relației?|Predicție|
|**R²**|Cât de bine explică<br>modelul variația datelor?|Calitate|


## **◼ 6. Precizări privind notațiile**


_O u t [_  _] =_


|Simbol|Denumire|Interpretare|
|---|---|---|
|**r**|Corelația Pearson|Măsoară forța<br>și direcția<br>relației liniare.|
|**R²**|Coeficientul<br>de determinare|Proporția de variație<br>explicată de model.|


_C8 Regresia liniara.nb_ **11**

##### **3. Ce este regresia liniară? Modelul matematic**

## **◼ Scurt istoric**


Conceptul de regresie liniară a fost introdus în **1884** de către **[Francis Galton](https://galton.org/photos/?form=MG0AV3)** în lucrarea sa
“ _Regression_ _towards_ _[Mediocrity](https://galton.org/essays/1880-1889/galton-1886-jaigi-regression-stature.pdf)_ _in_ _Hereditary_ _Stature_ ”, în care studiază relațiile dintre
înălțimea părinților și copiilor lor în baza noțiunii de “ **regresie către medie** ”. **Galton a**
**observat că înălțimea copiilor adulți este mai aproape de înălțimea medie decât cea a**
**părinților lor** .


Tot Galton, în 1886, a introdus și conceptul de corelație dintre două mărimi. Conceptul de
regresie liniară a fost **formalizat statistic de Karl Pearson** (legătura dintre regresia liniară
și coeficientul de corelație, Metoda celor mai mici pătrate).

## **◼ Analiza de corelație**


O analiză de corelație sau de regresie liniară simplă poate determina dacă două variabile
numerice sunt semnificativ legate liniar.


Analiza de corelație oferă informații despre forța și direcția relației liniare dintre cele două
variabile, în timp ce analiza de regresie liniară simplă estimează parametrii unei ecuații
liniare care poate fi utilizată pentru a prezice valorile unei variabile pe baza celeilalte.


**12** _C8 Regresia liniara.nb_


Regresia liniară este un model fundamental în învățarea automată, utilizat pentru a prezice

   - valoarea unei **variabile continue** (dependente) în baza valorilor a uneia sau a mai multor
variabile independente. Este o metodă simplă, dar puternică, cu o gamă largă de aplicații în
diverse domenii.


Sistemele reale studiate cu succes prin metodat regresiei liniare, dar și a celei neliniare, au
mai multe componente in comun. Pentru fiecare caz examinat există un set de variabile,
numite **intrări**, care sunt măsurate sau presetate. Valorile acestor intrări influențează
asupra uneia sau a mai multor **ieșiri** . Scopul cercetării este de a folosi valorile intrărilor
pentru a prezice valorile iesirilor.


În literatura statistică intrările sunt numite predictori, iar în general - **variabile indepen-**
**dente** . În literatura privind recunoașterea paternelor se preferă termenul **caracteristici** .
Ieșirile sunt numite și **răspunsuri** sau în general - **variabilele dependente** .


Modelul de regresie liniară presupune o relație liniară între **variabila dependentă** _y_ și
**variabilele independente** _x_ 1, _x_ 2, ..., _xp_ . Modelul liniar se bazează implicit pe anumite
ipoteze referitoare la sistemul real studiat, ceea ce conduce la previziuni stabile, dar, nu
întotdeauna exacte. Așadar, în regresia liniară pentru un vector al intrărilor
_x_ = { _x_ 1, _x_ 2, …, _xp_ } se prezice ieșirea _y_ folosind funcția liniară/afină:


_p_

_y_ = β _o_ + ∑ _i_ =1 _xi_ β _i_ .


Anume o funcție de acest tip este numită model de regresie liniară.


Termenul β0 este numit intercept (constanta), cunoscut în învățarea automată și sub
numele de **deviere** . Adesea este util să se includă în vectorul _x_    - componentă/variabilă
constantă _x_ 0 = 1, iar în vectorul β = {β1, β2, …, β _p_ } termenul β0, ca apoi să se poată funcția
liniară:



și sub forma vectorială:



_p_

_y_ = ∑ _i_ =0 _xi_ β _i_,


_y_ = _x_ _[T]_ β .


#### ◻ Interpretarea parametrilor



_p_

Modelul de regresie liniară se examinează și sub forma _y_ = β _o_ + ∑ _i_ =1 _xi_ β _i_ + ε, unde ε este

termenul de eroare care captează variațiile variabilei _y_ ce nu pot fi explicate prin variația
valorilor variabilelor independente _x_ 1, _x_ 2, ..., _xp_ . În continuare, termenul ε este omis din
considerente de simplitate.



Modelul de regresie liniară se examinează și sub forma _y_ = β _o_ + ∑ _i_ =1


_C8 Regresia liniara.nb_ **13**

## **◼ Procesul de învățare**


Modelul de regresie liniară este antrenat pe un set de date cunoscute (perechi de valori _x_ și
_y_ ). Algoritmul de învățare ajustează pe setul de date parametrii modelului β0, β1, β2, ..., β _p_
pentru a minimiza **eroarea de predicție** .

## **◼ Exemple comune de aplicații**


  - _Estimarea prețurilor imobiliare_ : predicția prețului unei case pe baza caracteristicilor sale

(suprafață, locație, număr de camere etc.)


  - _Predicția cererii de produse_ : estimarea cantității de produse pe care o companie ar trebui

să o producă în funcție de factori economici, sezonieri etc.


  - _Analiza riscurilor financiare_ : evaluarea probabilității ca un client să nu ramburseze un

credit.

## **◼ Avantaje**


  - Simplu de implementat și interpretat.


  - Eficient din punct de vedere computațional.


  - Robust și stabil.


  - Oferă o bază solidă pentru modele mai complexe.

## **◼ Dezavantaje**


  - Presupune o relație liniară între variabile.


  - Poate fi sensibil la valori aberante din setul de date.


  - Nu este potrivit pentru probleme de clasificare.


Regresia liniară este un instrument **fundamental** în învățarea automată, cu o gamă largă
de aplicații în diverse domenii.

Este o metodă simplă, dar puternică, care poate fi utilizată pentru a prezice variabile continue cu o acuratețe rezonabilă.


**14** _C8 Regresia liniara.nb_

##### **4. Metoda celor mai mici pătrate**

## **◼ Expunerea metodei**


Cum să determinăm modelul liniar _y_ = _x_ _[T]_ β pentru un set de date de antrenament?


Există diverse metode, dar de departe cea mai populară este metoda celor mai mici pătrate
în care coeficienții sunt aleși ca să minimizeze suma pătratelor erorilor dintre valorile observate _yi_, _i_ = 1, ..., _n_, și cele estimate _xiT_ β:



_n_

RSS (β) = 

_i_ =1



 _yi_ - _xiT_ β2



unde RSS este abreviere de la _„Residual Sum of Squares_ ”.


Funcția RSS(β) este pătratică și convexă în raport cu β și deaceea minimul ei există, pentru orice date de intrare, dar poate să nu fie unic.


Funcția poate fi scrisă și în notație matriceală:


RSS (β) = ( _y_                - _X_ β) _[T]_ ( _y_                - _X_ β)


unde _X_ este o matrice _n_ × _p_ în care fiecare linie este un vector _x_ de intrare, iar vectorul _y_
conține toate cele _n_ ieșiri pentru cei _n_ vectori de intrare.


Prin diferențiere, se ajunge cu ușurință la ecuația normală:


_X_ _[T]_ ( _y_             - _X_ β) = 0


Dacă _X_ _[T]_ _X_ este o matrice nesingulară, atunci soluția ecuației există și poate fi reprezentată
în felul următor:

β [] =  _X_ _[T]_ _X_  [-][1] _X_ _[T]_ _y_


**Remarcă.** În cazul regresiei liniare simple, de - singură variabilă _x_, pentru formula
_y_ = β0 + β1 _x_, panta și interceptul pot fi calculate conform formulelor:



β0 =



∑ _nj_ =1 _y_ _j_ ∑ _nj_ =1 _x_ 2 _j_ - ∑ _nj_ =1 _x_ _j_ ∑ _nj_ =1 _x_ _j y_ _j_

_n_ ∑ _nj_ =1 _x_ 2 _j_   - ∑ _nj_ =1 _x_ _j_  [2]



_nj_ =1 _y_ _j_



_nj_ =1 _x_ _j_ ∑ _nj_ =1



β1 =



_n_ ∑ _nj_ =1



_nj_ =1 _x_ _j y_ _j_ - ∑ _nj_ =1



_n_ ∑ _nj_ =1 _x_ 2 _j_ - ∑ _nj_ =1 _x_ _j_  [2]


_C8 Regresia liniara.nb_ **15**


unde _n_ este numărul de observații/perechi _x_ _j_, _y_ _j_ în setul de date.
Formulele pot fi scrise și în altă formă, utilizând noțiuni cunoscute în regresia liniară:



∑ _nj_ =1 ( _x_ _j_ - _x_ ) ( _y_ _j_ - _y_ )

∑ _nj_ =1 ( _x_ _j_  - _x_ ) ²



β1 =



Cov( _x_, _y_ )

=
Var( _x_ )



β0 = _y_                    - β1 _x_


unde:
_x_ este valoarea medie a datelor pentru variabila independentă _x_,
_y_ este valoare medie a datelor pentru variabila dependentă _y_,
Cov( _x_, _y_ ) = ∑ _nj_ =1 ( _x_ _j_ - _x_ ) ( _y_ _j_ - _y_ ) este covarianța dintre _x_ și _y_,

Var( _x_ ) = ∑ _nj_ =1 ( _x_ _j_ - _x_ ) ² este varianța _x_ .


Pentru date de intrare arbitrare _x_ 0 ieșirea este:

_y_ [] ( _x_ 0) = _x_ 0 _T_ β


Întreaga suprafață este caracterizată prin _p_ parametri. Intuitiv, există impresia că nu e
nevoie de un set de date foarte mare pentru un astfel de model.


Să prezentăm un exemplu ilustrativ în cazul 2 dimensional. Datele de intrare reprezintă o
listă de perechi de numere, care pot fi interpretate în calitate de coordonate ale punctelor în
plan.










**16** _C8 Regresia liniara.nb_











Funcția RSS(β) poate fi definită în felul următor:









Să reprezentăm grafic această funcție:





Minimul acestei funcții poate fi determinat folosind posibilitățile limbajului Wolfram:


_C8 Regresia liniara.nb_ **17**























Să luăm un alt exemplu:


**18** _C8 Regresia liniara.nb_








_C8 Regresia liniara.nb_ **19**







|100<br>50|Col2|
|---|---|
|-40<br>-20<br>-50|20<br>40|


Utilizăm funcția RSS definită mai sus și afișăm graficul funcției în raport cu variabilele/parametrii b și b0:





Găsim valorile parametrilor:






**20** _C8 Regresia liniara.nb_


Putem reprezenta acum grafic:








|100<br>50|Col2|
|---|---|
|-40<br>-20<br>100<br>-50|20<br>40|






## **◼ Exemplu simplu**

Să presupunem că deținem un magazin alimentar și dorim să prezicem vânzările zilnice de
înghețată în baza temperaturii medii zilnice. Avem următoarele date colectate pe parcursul
a 10 zile:


_C8 Regresia liniara.nb_ **21**








|Zi|Temperatura (°C)|Vânzări înghețată (kg)|
|---|---|---|
|1|11|16|
|2|13|18|
|3|15|20|
|4|17|24|
|5|19|28|
|6|21|30|
|7|23|32|
|8|25|34|
|9|27|38|
|10|29|40|


**22** _C8 Regresia liniara.nb_


Calculul manual al parametrilor pentru modelul de regresie liniară:


y[x_] := β0 + β1 x



Calculul mediei temperaturilor și vânzărilor:
Media temperaturilor ( _x_ ) = [11][ +][ 13][ +][ 15][ +][ ...][ +][ 29]




[ +] [ +] = 20°C

10



Media vânzărilor ( _y_ ) = [16][ +][ 18][ +][ 20][ +][ ...][ +][ 40]




[ +] [ +] = 28 kg

10

























Calculul pantei (coeficientului unghiular) β1:



,
∑ _nj_ =1 ( _x_ _j_ - _x_ ) ²



β1 =



∑ _j_ =1



_nj_ =1 ( _x_ _j_ - _x_ ) ( _y_ _j_ - _y_ )



unde:
_x_ _j_ - temperatura din ziua _j,_
_x_ - media temperaturilor,


_C8 Regresia liniara.nb_ **23**


_y_ _j_   - vânzările de înghețată din ziua _j,_
_y_ = media vânzărilor,



β1 =



(11 - 20) (16 - 28) + (13 - 20) (18 - 28) + ... + (29 - 20) (40 - 28)

,
(11 - 20) ² + (13 - 20) ² + ... + (29 - 20) ²



β1 = 1.3697.













Calculul interceptului (constantei) β0:



β0 = _y_ - β1 _x_ .
















**24** _C8 Regresia liniara.nb_


β0 = 28 - 1.3697 * 20
β0 = 0.606061


**Ecuația de regresie liniară:**
**Vânzări înghețată** = **0.606061** + **1.3697** **Temperatura**







15.6727


18.4121


21.1515


23.8909


26.6303


29.3697


32.1091


34.8485


37.5879


40.3273


|Temperatura (°C)|11|
|---|---|
|Vânzări înghețată (kg)|16|


|Vânzări înghețată (kg)|16|
|---|---|
|Temperatura (°C)|13|
|Vânzări înghețată (kg)|18|


|Vânzări înghețată (kg)|18|
|---|---|
|Temperatura (°C)|15|
|Vânzări înghețată (kg)|20|


|Vânzări înghețată (kg)|20|
|---|---|
|Temperatura (°C)|17|
|Vânzări înghețată (kg)|24|


|Vânzări înghețată (kg)|24|
|---|---|
|Temperatura (°C)|19|
|Vânzări înghețată (kg)|28|


|Vânzări înghețată (kg)|28|
|---|---|
|Temperatura (°C)|21|
|Vânzări înghețată (kg)|30|


|Vânzări înghețată (kg)|30|
|---|---|
|Temperatura (°C)|23|
|Vânzări înghețată (kg)|32|


|Vânzări înghețată (kg)|32|
|---|---|
|Temperatura (°C)|25|
|Vânzări înghețată (kg)|34|


|Vânzări înghețată (kg)|34|
|---|---|
|Temperatura (°C)|27|
|Vânzări înghețată (kg)|38|


|Temperatura (°C)|29|
|---|---|
|Vânzări înghețată (kg)|40|



**Interpretarea parametrilor:**
Bias-ul (constanta, interceptul) β0: Vânzările zilnice de înghețată ar fi de 0,606061 kg dacă
temperatura ar fi de 0°C (ceea ce este puțin probabil în realitate).
Panta (coeficientul unghiular) β1: O creștere a temperaturii medii zilnice cu 1°C duce la o
creștere a vânzărilor zilnice de înghețată cu 1.3697 kg.


_C8 Regresia liniara.nb_ **25**


**Predicția:**
Putem utiliza ecuația de regresie liniară pentru a prezice vânzările de înghețată pentru o zi
cu o temperatură medie cunoscută. De exemplu, dacă temperatura medie pentru o zi
viitoare este de 25°C, predicția vânzărilor de înghețată ar fi:









Vânzări înghețată = **0.606061** + **1.3697 *** **25** = 34.8485 kg


Observații:


Acest exemplu este o simplificare a realității, deoarece nu ia în considerare alți factori care
pot influența vânzările de înghețată (de exemplu: prețul, promoțiile, concurența).


Regresia liniară este o metodă utilă pentru a prezice variabile continue, dar este important
să se ia în considerare limitările sale și să se utilizeze cu prudență.

## **◼ Exemple celebre**


Să enumerăm câteva exemple celebre de regresie liniară din istorie, știință și economie, cu
un impact real semnificativ.

#### **◻ 1. Studiul lui Francis Galton privind ereditatea (1886)**


 - **Variabile** : Înălțimea părinților vs. înălțimea copiilor.


 - **Descoperire** : Galton a observat o “ _regresie către medie_ ” – copiii părinților foarte înalți

tind să fie mai scunzi decât părinții lor, iar copiii părinților scunzi tind să fie mai înalți.
Acest fenomen a dat numele regresiei în statistică.


 - **Funcție** : _y_ = β0 + β1 _x_ + ε, unde y este înălțimea copilului, _x_  - înălțimea medie a părinților.

#### **◻ 2. Funcția de producție Cobb-Douglas (1928)**


 - **Variabile** : Producția economică (Y) în funcție de muncă (L) și capital (K).


 - **Model** : Y = _A L_ [α] _K_ [β] .


 - **Regresie** **liniară** : Logaritmarea transformă modelul într-unul liniar:
ln( _Y_ ) = ln( _A_ ) + α ln( _L_ ) + β ln( _K_ ).


 - **Semnificație** : A pus bazele econometriei moderne.


**26** _C8 Regresia liniara.nb_

#### **◻ 3. Modelul CAPM (Capital Asset Pricing Model) în finanțe (1964)**


  - **Variabile** : Rentabilitatea unui activ ( _Ri_ ) vs. rentabilitatea pieței ( _Rm_ ).


  - **Funcție** : _Ri_ = _Rf_ + β _i_ ( _Rm_   - _Rf_ ) + ε, unde β _i_ este coeficientul de regresie ce măsoară riscul
sistematic.


  - **Aplicație** : Folosit pentru evaluarea riscului și a rentabilității așteptate a acțiunilor.

#### **◻ 4. Curba lui Phillips (1958)**


  - **Variabile** : Rata șomajului vs. rata inflației.


  - **Regresie** : Phillips a identificat o relație inversă între șomaj și creșterea salariilor (proxy

pentru inflație) în Marea Britanie.


  - **Controverse** : Relația s-a dovedit instabilă pe termen lung, dar a influențat politici mon
etare decenii la rând.

#### **◻ 5. Studiul Framingham despre boli cardiovasculare (1948 - prezent)**


  - **Variabile** : Factori de risc (fumat, colesterol, tensiune arterială) vs. apariția bolilor de inimă.


  - **Regresie liniară și logistică** : A identificat corelații semnificative, fundamentând pre
venția modernă a bolilor cardiovasculare.

#### **◻ 6. Analiza schimbărilor climatice (secolul XX-XXI)**


  - **Variabile** : Emisii de CO2 (x) vs. creșterea temperaturii globale (y).


  - **Regresie** : Modele liniare și polinomiale arată o relație puternică pozitivă, susținând teori
ile despre încălzirea globală.

#### **◻ 7. Predicții în sport (Moneyball, 2003)**


  - **Variabile** : Statistici ale jucătorilor (ex: on-base percentage) versus succesul echipei.


  - **Regresie** : Analiza lui Billy Beane (Oakland Athletics) a revoluționat managementul
sportiv prin selecția jucătorilor pe baza datelor.

#### **◻ 8. Prețul casei vs. suprafața locuibilă**


  - **Exemplu simplu** : Una dintre cele mai comune aplicații în econometrie.


_C8 Regresia liniara.nb_ **27**


  - **Funcție** : **preț** = β0 + β1 **suprafața** + ε.


  - **Utilizare** : Evaluări imobiliare și modele de piață.

#### **◻ De ce sunt celebre?**


  - **Impact științific** : Au schimbat paradigme în economie, medicină și sociologie.


  - **Simplitate** **vs.** **putere** : Demonstrează cum un instrument matematic simplu poate

dezvălui relații complexe.


  - **Aplicații practice** : De la politici economice la predicții zilnice.


**28** _C8 Regresia liniara.nb_

##### **5. Regresia liniară vs cea logistică**


Regresia liniară este utilizată în cazul când valorile variabilei dependente sunt de tip **con-**
**tinuu** . În cazul când valorile sunt discrete, regresia liniară nu mai funcționează. În baza ei
se construiește regresia logistică.


Regresia **liniară** și cea **logistică** sunt două tipuri de modele statistice utilizate pentru a
analiza relațiile dintre variabile. Deși ambele sunt folosite în scopuri de predicție, ele diferă
în ceea ce privește tipurile de date pe care le modelează și metoda de calcul. Iată principalele diferențe:

## ◼ Regresia liniară


  - **Scop** : Se folosește pentru a modela relația dintre o variabilă dependentă (de răspuns)

continuă și una sau mai multe variabile independente (predictori).


  - **Model** : Relația dintre variabile este reprezentată printr-o linie dreaptă.


  - **Funcția** : _y_ = β0 + β1 _x_ 1 + β2 _x_ 2 + … + β _n xn_ + 𝜖


  - **Predicții** : Valoarea variabilei dependente este continuă și poate lua orice valoare reală.


  - **Aplicații** : Folosit pentru predicția vânzărilor, prețurilor, veniturilor etc.

## ◼ Regresia logistică


  - **Scop** : Se folosește pentru a modela relația dintre   - variabilă dependentă binară

(dichotomă) și una sau mai multe variabile independente.


  - **Model** : Relația dintre variabile este reprezentată printr-o curbă logistică (forma literei “S”).


În loc să modeleze direct probabilitatea, regresia logistică modelează logaritmul natural al
raportului dintre probabilitatea de succes și probabilitatea de eșec (log-odds), folosind
funcția logit:


logit( _p_ ) = ln _[p]_
1- _p_ [= β][0][ + β][1] _[ x]_ [1][ + β][2] _[ x]_ [2][ + … + β] _[n][ x][n]_


sau funcția logistică:


_P_ ( _y_  1) = 1
1 +  [-(β][0][+β][1] _[ x]_ [1][+β][2] _[ x]_ [2][+…+β] _[n][ x][n]_ [)]


  - **Predicții** : Valoarea variabilei dependente este probabilitatea (între 0 și 1) ca evenimentul
de interes să aibă loc.


_C8 Regresia liniara.nb_ **29**


  - **Aplicații** : Folosit pentru clasificarea și predicția evenimentelor binare, cum ar fi deter
minarea probabilității ca un client să cumpere un produs, diagnosticul unei boli
(prezență/absență) etc.


În concluzie, regresia liniară este potrivită pentru predicții pe baza unor valori continue, în
timp ce regresia logistică este adecvată pentru clasificarea și predicția evenimentelor
binare.

## ◼ Funcții de activare/logistice


**Funcția logistică** : f(x) = σ(x) = [] _[x]_ 1

1+ _[x]_ [ = ] 1+ [-] _[x]_


numită și sigmoidă, este o funcție matematică utilizată în regresia logistică pentru a transforma valoarea unei variabile independente în probabilitate. Funcția sigmoidă are forma
literei S, similară cu o curbă logistică, și mapează valorile reale pe intervalul [0, 1].


Termenul „logistic” pentru această funcție **are rădăcini istorice** în aplicarea sa la modelele
de creștere. Funcția logistică a fost introdusă pentru prima dată de **Pierre François Ver-**
**hulst în secolul al XIX-lea** pentru a modela creșterea populației. El a numit-o „curba logistică” deoarece descria o formă particulară de creștere care era continuă și mărginită.

#### **◻ Clarificare privind relația cu legea normală**

Funcția logistică captează un model de creștere mai realist comparativ cu funcțiile liniare,
luând în considerare creșterea rapidă inițială care încetinește treptat pe măsură ce se
apropie de un plafon maxim, reflectând limitările resurselor sau capacitatea de suport în
sistemele biologice.


Astfel, termenul „logistic” a rămas datorită utilizării sale istorice în modelele de creștere și
proprietăților sale matematice, deși este aplicabil la o gamă largă de fenomene dincolo de
creștere.

#### **◻ Exemple de funcții de activare/logistice/sigmoide** **◻ Exemple de aplicații ale sigmoidei în regresia logistică**


  - Predicția probabilității ca un client să cumpere un produs:


Variabila independentă ar putea fi venitul clientului, iar variabila dependentă ar fi o valoare binară (0 - nu a cumpărat, 1 - a cumpărat). Funcția sigmoidă transformă venitul
clientului într-o probabilitate ca acesta să cumpere produsul.


  - Predicția probabilității ca un pacient să aibă   - anumită boală:


Variabila independentă ar putea fi un set de simptome ale pacientului, iar variabila dependentă ar fi o valoare binară (0 - nu are boala, 1 - are boala). Funcția sigmoidă ar transforma simptomele pacientului într-o probabilitate ca acesta să aibă boala.


**30** _C8 Regresia liniara.nb_

#### **◻ Avantaje și dezavantaje**


**A** **v** **a** **n** **t** **a** **j** **e** :
Sigmoida este o funcție non-liniară, permițând modelarea relațiilor complexe dintre variabile.
Sigmoida este o funcție monotonă, asigurând o creștere sau o descreștere constantă a
probabilității.
Sigmoida este o funcție diferențiabilă, permițând utilizarea algoritmilor de optimizare pentru
antrenarea modelului.


**Dezavantaje** :
Sigmoida poate fi sensibilă la valori aberante din setul de date.
Sigmoida poate fi dificil de interpretat în anumite contexte.

#### **◻ Concluzie**


_Sigmoida este o funcție importantă în regresia logistică, permițând transformarea vari-_
_abilelor independente în probabilități_ .


Funcția sigmoidă are forma literei S și mapează valorile reale în intervalul (0, 1).
Sigmoida este utilizată în diverse aplicații, cum ar fi predicția probabilității ca un client să
cumpere un produs sau ca un pacient să aibă o anumită boală.


_C8 Regresia liniara.nb_ **31**

##### **Setări**

## ◼ Setări notebook ◼ Setări celule


