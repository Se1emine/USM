##### **1. Teste pentru variabile categorice: χ², Fisher**

## ◼ Obiectiv :


  - Înțelegerea și aplicarea testelor χ² și Fisher pentru evaluarea dependenței statistice între

variabile categorice, cu accent pe:


   - raționamentul inferențial,

   - condițiile de validitate

   - și interpretarea corectă a rezultatelor.

## ◼ Context și poziționare în curs :


   - Context:

    - În multe aplicații reale, datele nu sunt numerice, ci categorice, fiind organizate sub
forma **frecvențelor** în tabele de contingență (таблицы сопряжённости). În aceste
situații, metodele parametrice studiate anterior (t-test, z-test), dar și ANOVA, care
va urma, nu sunt aplicabile.


**2** _C6 Teste pentru variabile categorice_ χ _² Fisher.nb_

## **Paradigma Inferenței Statistice**





**CODIFICARE** **/**

**NUMĂRARE**



**DATE CATEGORIALE**

( _Nominal_ / _Ordinal_ )

|Col1|DA|NU|
|---|---|---|
|**EFECT**|**45**|**12**|
|**CONTROL**|**30**|**80**|



**Focus:** **Frecvențe** **(n)** **și** **Proporții** **(%)**



**TRANZIȚIE** **LOGICĂ:** **De** **la** **măsurarea** **mărimii** **efectului** **la** **analiza** **distribuției** **frecvențelor**


- Scopul temei:

  - Această temă introduce metodele de inferință statistică pentru **variabile cate-**

**gorice**, având ca obiectiv evaluarea dependenței statistice dintre categorii sau
verificarea conformității cu o distribuție teoretică.

- Instrumente principale:

  - Testul χ² (Chi-pătrat) — **metodă asimptotică**, pentru eșantioane mari

  - Testul exact Fisher — **metodă exactă**, pentru eșantioane mici (tabele 2×2)

- Accentul cade pe:

  - structura datelor ( **frecvențe**, nu valori)

  - **raționament inferențial**, nu pe mecanica formulei

- Cunoștințe prealabile necesare:

  - definirea variabilelor nominale/ordinale


_C6 Teste pentru variabile categorice_ χ _² Fisher.nb_ **3**


     - construcția tabelelor de contingență.

Cum putem demonstra matematic că genul unei persoane influențează preferința pentru un
anumit tratament, dacă nu putem calcula o ‘medie’ a genului?


   - Context și poziționare (pe scurt):

     - **Problema** : Până acum am comparat medii (z, t). Ce facem când datele noastre
sunt etichete (ex: culoarea ochilor, supraviețuitor/decedat, admis/respins)?

     - **Soluția** : Trecem de la analiza valorilor la analiza asocierilor între frecvențe.

   - Instrumente (pe scurt):

     - **χ²** **(Chi-pătrat)** : „Radarul” pentru eșantioane mari (bazat pe aproximarea distribuției normale).

     - **Fisher** : „Lupa” pentru eșantioane mici (calculează probabilitatea exactă a fiecărei
combinații).


**4** _C6 Teste pentru variabile categorice_ χ _² Fisher.nb_

##### **2. Variabile categorice și tabele de contingență**

## ◼ 1. Clasificarea Datelor Calitative


Spre deosebire de variabilele numerice, cele categorice ne spun „ **ce fel de** ”, nu „ **cât de**
**mult** ”.


   - **nominale** : categorii fără o ordine intrinsecă (ex: Sex, Stare civilă, Grupa sanguină).

   - **ordinale** : categorii cu o ierarhie logică (ex: Nivel educație, Satisfacție pe scală Likert).

**Regula de aur** : În această paradigmă, unitatea de măsură este **Frecvența (N)** . Nu calculăm media culorii ochilor, ci numărăm câți subiecți au ochi albaștri.

## ◼ 2. Anatomia Tabelului de Contingență (таблица сопряжённости)


Este instrumentul fundamental pentru a studia **asocierea** dintre două variabile.


   - **Frecvențe Observate** (O): Datele numărate direct din eșantion.

   - **Frecvențe Marginale** : Totalurile pe rânduri și coloane (esențiale pentru calculul proba
bilităților).

   - **Frecvențe Relative** : Proporțiile sau procentele (ajută la compararea grupurilor de
dimensiuni diferite).

Așadar:


   - tabel: 1×k, 2×2, r×c

   - frecvențe:

## ◼ 3. Exemplu Practic: Succesul Academic


Întrebare:


   - Este reușita la examen independentă de genul candidatului?

Variabile:


   - **Variabila 1 (Expunere):** Gen (Bărbați / Femei)

   - **Variabila 2 (Rezultat)** : Promovarea (Categorică, Binara).

   - **Obiectiv** : Căutăm **Dependența** . Dacă procentul de promovare este semnificativ

diferit între bărbați și femei, spunem că variabilele sunt asociate.

👉 Această structură este „input-ul” necesar pentru testul  χ² sau Fisher, în funcție de
dimensiunea eșantionului. Înainte de a rula testul, trebuie să ne asigurăm că frecvențele
sunt suficient de mari.


   - **Nota bene.** Nu testăm diferențe de medii, ci **dependența dintre clasificări** .


_C6 Teste pentru variabile categorice_ χ _² Fisher.nb_ **5**

##### **3. Testul χ² de Independență**

## ◼ 1. Ideea fundamentală: „Cât de mare este surpriza?”


   - Testul χ² evaluează mărimea abaterii globale dintre:

     - frecvențele observate (datele reale _O_ )

     - frecvențele așteptate sub ipoteza nulă H₀ (teorie _E_ )
**Logica** : Dacă ipoteza de independență (H₀) este adevărată, atunci diferența ( _O-E_ ) ar
trebui să fie mică, rezultând dintr-un simplu hazard al eșantionării.

   - **Măsurătoarea** : Sumăm pătratele abaterilor relative pentru a obține o singură valoare
care descrie întregul tabel.

## ◼ 2. Tipuri de teste χ²


   - a) Test de independență:

     - verifică existența unei relații între două variabile categorice

     - se aplică tabelelor de contingență r×c

   - b) Test de omogenitate:

     - verifică dacă **mai multe populații** au aceeași distribuție pe categorii

     - structură matematică identică cu testul de independență

   - c) Test de adecvare (goodness-of-fit)

     - verifică dacă o distribuție observată respectă o **distribuție teoretică specificată**

## ◼ 3. Ipoteze statistice

   - H₀ (ipoteza nulă): **independență** / distribuție specificată

     - variabilele sunt independente (Ex: Genul nu influențează promovarea)

     - (sau distribuția observată coincide cu cea teoretică)

   - H₁ (ipoteza alternativă): **dependență** / abatere de la distribuție

     - există dependență statistică (Ex: Șansele de promovare diferă între grupuri)

     - (sau o abatere semnificativă față de distribuția teoretică)

   - Important: testul nu indică direcția relației, ci doar existența ei. Testul este **omnibus**    - ne spune că există o

asociere, dar nu ne spune unde este ea sau care este direcția ei (pentru asta analizăm reziduurile).

## ◼ 4. Statistica de test χ²


   - Formula χ²



χ² = 

_i_, _j_



( _O_ ij - _E_ ij) [2]

_E_ ij



unde:

_O_ ij - frecvența observată
_E_ ij - frecvența așteptată sub _H_ 0


**6** _C6 Teste pentru variabile categorice_ χ _² Fisher.nb_


   - Grade de libertate:

df = (r−1)(c−1)

   - Interpretare geometrică și intuitivă

χ² mic  → diferențe compatibile cu fluctuații aleatoare
χ² mare → abatere greu de explicat prin hazard

   - **Regula de Aur (Validitate)** : Toate frecvențele așteptate ( _E_ ) trebuie să fie ≥ 5. Dacă
eșantionul este prea mic, testul χ² își pierde precizia și trecem la **Testul Exact Fisher.**

## ◼ 5. Condiții de aplicabilitate


   - Frecvențe așteptate ≥ 5 (regula practică)

   - eșantioane **suficient de mari**

   - observații **independente**

   - Dacă aceste condiții nu sunt îndeplinite → testul Fisher


_C6 Teste pentru variabile categorice_ χ _² Fisher.nb_ **7**

#### **◻ Vizualizarea Distribuției și Decizia**













**Interpretarea Rezultatului**


χ² **mic**  p- **value mare** (> 0.05): Menținem _H_ 0. Diferențele dintre _O_ și _E_ sunt minore.


χ² **mare**  p-value mic (≤ 0.05): Respingem _H_ 0. Există o asociere statistic semnificativă.


**8** _C6 Teste pentru variabile categorice_ χ _² Fisher.nb_


**Nota bene.** Alte variante nu sunt posibile. Dacăt totuși apar, explicația este doar în calcule
incorecte.


**Remarcă** : χ² nu compară direct categorii, ci măsoară cât de improbabil este tabelul observat dacă independența ar fi adevărată.


_C6 Teste pentru variabile categorice_ χ _² Fisher.nb_ **9**

##### **4. Interpretarea rezultatului χ² și decizia statistică**

## ◼ 1. Ce măsoară efectiv χ²? Esența Testului: „Zgomot” sau „Semnal”?


Statistica χ² nu este doar un număr, ci o măsură a surprizei statistice.


  - χ² **mic** : Abaterile sunt neglijabile; datele arată exact cum ne-am aștepta dacă variabilele

ar fi independente ( **Zgomot** ).


  - χ² **mare** : Abaterile sunt prea mari pentru a fi ignorate; sugerează o structură sau o legă
tură reală în date ( **Semnal** ).


Statistica χ² cuantifică abaterea globală dintre frecvențele observate și frecvențele așteptate sub ipoteza nulă H₀.


Cu cât această abatere este mai mare, cu atât este mai puțin plauzibil ca datele observate
să provină dintr-o populație în care variabilele sunt independente.

## ◼ 2. Distribuția statisticii χ²


Sub ipoteza nulă H₀, statistica χ² urmează aproximativ o distribuție χ² cu df = (r − 1)(c − 1)
grade de libertate.

#### **◻ Formula**


Funcția de densitate de probabilitate (PDF) pentru o variabilă aleatorie _X_ care urmează o
distribuție χ² cu _k_ grade de libertate este definită prin formula:



_x_

2 _x_ - 0



_x_

_k_

2 []



_k_

2 [-][1]  [-]



_f_ ( _x_ ; _k_ ) =



2



1

_k_

2 Γ



0 _x_ ≤ 0



unde:


**10** _C6 Teste pentru variabile categorice_ χ _² Fisher.nb_







Această distribuție permite evaluarea probabilității de a observa o valoare a statisticii cel
puțin la fel de mare ca cea calculată.


_C6 Teste pentru variabile categorice_ χ _² Fisher.nb_ **11**


Out[3]










## ◼ 3. p-value: semnificația statistică

Probabilitatea _p_ răspunde la întrebarea: „Dacă lumea ar fi guvernată de hazard ( _H_ 0 adevărată), care sunt șansele să vedem aceste date?”


p-value reprezintă probabilitatea de a obține o abatere cel puțin la fel de mare ca cea observată, presupunând că ipoteza nulă H₀ este adevărată.


 - p ≤ 0.05: Șansele sunt sub 5%. Este prea puțin probabil să fie hazard  **Semnificativ** .


 - p > 0.05: Șansele sunt mari. Hazardul este o explicație plauzibilă  **Nesemnificativ** .

## ◼ 4. Decizia statistică


Pentru un nivel de semnificație α:

  - dacă p-value ≤ α → respingem ipoteza nulă H₀

  - dacă p-value > α → nu respingem ipoteza nulă H₀

Decizia statistică nu este o afirmație de certitudine, ci una probabilistică.


**12** _C6 Teste pentru variabile categorice_ χ _² Fisher.nb_


**Comparație** **Verdict statistic** **Concluzie cercetare**

|p ≤α|Respingem H<br>0|
|---|---|
|_p_ > α|**Nu respingem H0**|


## ◼ 5. Limitele Testului: Ce putem și ce NU putem concluziona (Ce nu este χ²)


Este vital să înțelegem că un rezultat „semnificativ” are limitări severe:


  - **NU implică Cauzalitate** : Dacă genul și promovarea sunt asociate, nu înseamnă că genul
cauzează promovarea (pot exista variabile ascunse, precum vechimea).


  - **NU indică Direcția** : **χ²** ne spune că există o legătură, nu cine pe cine favorizează.


  - **Semnificație vs. Relevanță** (Значимость vs. Релевантность): Un eșantion uriaș poate

scoate un _p < 0.05_ pentru o diferență infimă, fără nicio importanță practică în viața reală.


Așadar, putem concluziona:


   - existența sau inexistența unei dependențe statistice

Nu putem concluziona:


   - relații cauzale (причинно-следственные связи)

   - direcția sau mecanismul dependenței

Pentru aceste aspecte sunt necesare analize suplimentare.


Out[6]=
















_C6 Teste pentru variabile categorice_ χ _² Fisher.nb_ **13**


**Remarcă** . Semnificația statistică nu implică automat relevanță practică. Pentru aceasta
este necesară evaluarea mărimii efectului.


**Замечание** . Статистическая значимость не подразумевает автоматически
практическую значимость. Для этого необходимо оценить величину эффекта.


**14** _C6 Teste pentru variabile categorice_ χ _² Fisher.nb_

##### **5. Testul Exact Fisher: Când numerele mici spun adevărul**

## ◼ 1. Motivație


  - Testul χ² este un test **asimptotic** și se bazează pe aproximații valabile pentru eșantioane

suficient de mari.


  - Dacă **frecvențele așteptate** sunt mici, aproximația poate deveni nesigură.


  - În astfel de situații, **testul exact Fisher** oferă o evaluare exactă a dependenței într-un

tabel de contingență **2×2** .

#### **◻ De ce Fisher și nu χ² ?**


Testul χ² este ca o hartă digitală care funcționează bine la zoom mare (eșantioane mari).
Când facem zoom pe date puține, „pixelii” (frecvențele discrete) devin vizibili, iar aproximarea asimptotică eșuează.


  - **Problema** : Regula lui Cochran spune că dacă peste 20% din celule au frecvențe aștep
tate _E < 5_, testul χ² nu mai este de încredere.


  - **Soluția** : Testul Fisher nu folosește o curbă teoretică, ci calculează direct probabilitatea

configurației specifice a tabelului tău folosind Distribuția Hipergeometrică.

#### **◻ Ideea probabilistică**

  - Sub H₀ (independență), și cu totaluri marginale fixate, probabilitatea unui anumit tabel
2×2 se calculează exact (distribuție hipergeometrică).


  - p-value se obține prin însumarea probabilităților tabelelor „cel puțin la fel de extreme” ca

cel observat (în funcție de definiția one-sided / two-sided folosită).

#### **Distribuția hipergeometrică**


Aceasta distribuțite descrie probabilitatea de a obține un număr de k succese în n extrageri
fără repunere dintr-o populație de mărime N care conține exact M succese.



_N_ - _M_



_P_ ( _X_ = _k_ ) =



_Ck_



_kM CnN_ -- _k_



_CnN_



unde:


_a_

- _Cb_ este coeficientul binomial („a luate câte b”).


- N: Numărul total de elemente (populația).


- M: Numărul total de succese din populație (ex: toți bărbații din studiu).


_C6 Teste pentru variabile categorice_ χ _² Fisher.nb_ **15**


  - n: Numărul de elemente extrase (ex: toți cei promovați).


  - k: Numărul de succese în eșantion (ex: bărbați promovați).

#### **Exemplu vizual pentru distribuția hipergeometrică**


Distribuția Hipergeometrică este modelul matematic ideal pentru situațiile în care efectuăm
extrageri dintr-o populație limitată, fără a pune obiectele înapoi. Spre deosebire de distribuția Binomială, aici fiecare extragere schimbă compoziția populației rămase și, implicit,
șansele următoarei extrageri.


Ne imaginăm o urnă care conține un total de 20 de bile (N=20). Știm că în interior sunt
exact 10 bile roșii (M=10) și 10 bile de altă culoare. Extragem la întâmplare un eșantion de
8 bile (n=8).


Graficul interactiv de mai jos ne răspunde la întrebarea: „Care este probabilitatea să
nimerim exact k bile roșii?”. Putem observa cum probabilitatea maximă se concentrează în
jurul valorii de 4 (media), dar există întotdeauna o șansă (mai mică) de a extrage mult mai
puține sau mult mai multe.


Creăm simularea interactivă în care graficul arăta care este probabilitatea să extragem
exact 0, 1, 2... 8 bile roșii.


**16** _C6 Teste pentru variabile categorice_ χ _² Fisher.nb_
















|k Mseeledcitaa|Col2|tμ = 20<br>9|
|---|---|---|
||||
||||
||||
||||
||||





_O u t [_  _] =_


#### **De ce este important pentru Testul Fisher?**

În testul Fisher, noi avem tabelul:


**Structura** **Tabelului** **de** **Contingență** **(Fisher)**


|Col1|Grup A|Grup B|Total|
|---|---|---|---|
|**Succes**|_k_|_n_ -_ k_|**_n_**|
|**Eșec**|_M_ -_ k_|_k_ -_ M_ -_ n_ +_ N_|**_N_ -****_ n_**|
|**Total**|**_M_**|**_N_ -****_ M_**|**_N_**|


_C6 Teste pentru variabile categorice_ χ _² Fisher.nb_ **17**


Testul Fisher folosește această distribuție pentru a vedea dacă valoarea k din prima celulă
este „extremă”.


  - **χ²-pătrat** presupune că datele se pot așeza oriunde pe o curbă continuă.


  - **Fisher** „știe” că nu poți avea 4.2 bărbați, ci doar 4 sau 5, și calculează probabilitatea

acestor trepte discrete.

## ◼ 2. Logica din spatele „Exactității”


Ne imaginăm că avem totalurile marginale fixate (ex: am testat exact 10 bărbați și 10
femei). Fisher calculează:


  - Toate combinațiile posibile de numere care pot intra în tabel fără a schimba totalurile.


  - Probabilitatea tabelului nostru observat în acest univers de combinații.


  - **p-value** : Suma probabilităților pentru tabelul nostru plus toate tabelele „mai extreme” (mai

defavorabile ipotezei nule).

## ◼ 3. Tabel Comparativ


_O u t [_  _] =_

|Aspect Comparativ|Testul χ²|Testul Exact Fisher|
|---|---|---|
|**Dimensiune Eșantion**|Mare (N > 40)|Mic (N < 20)|
|**Frecvențe Așteptate**|Toate celulele E ≥5|Cel puțin o celulă E < 5|
|**Tip Tabel**|Orice format (r × c)|De regulă 2 × 2|
|**Natură Matematică**|Asimptotic (Aproximație)|Exact (Combinatorică)|


## ◼ 4. Ce trebuie să reținem?


  - **Fisher este conservator** : În eșantioane mici, oferă o protecție mai mare împotriva eror
ilor de tip I (a vedea o legătură acolo unde nu există).


  - **Nu cauzalitate** : Chiar dacă este „exact”, limitele de la χ² rămân valabile: Fisher ne spune

că există o asociere, dar nu ne spune cine este cauza și cine este efectul.


**Nota bene** . Deși Fisher este „standardul de aur” pentru tabele 2×2 mici, pentru tabele mai
mari (ex: 3×4) calculul devine atât de complex încât computerele pot avea dificultăți, motiv
pentru care acolo revenim la χ² sau la metode de simulare Monte Carlo.


**18** _C6 Teste pentru variabile categorice_ χ _² Fisher.nb_

##### **6. Aplicarea testului exact Fisher pe un tabel 2×2**

## ◼ 1. Datele Observate (O)


Folosim un tabel 2×2 pentru a evalua asocierea dintre gen și promovare. Chiar dacă eșantionul pare mare (N=130), Fisher este util pentru a confirma rezultatele aproximative ale χ².


_O u t [_  _] =_

|Col1|Promovat|Nepromovat|
|---|---|---|
|**Bărbați**|**42**|**18**|
|**Femei**|**58**|**12**|


## ◼ 2. Testul exact Fisher (p-value) prin exemplu






|Col1|Promovat|Nepromovat|
|---|---|---|
|**Bărbați**|42|18|
|**Femei**|58|12|






## ◼ 3. Semnificație Statistică vs. Relevanță Practică


  - semnificație statistică

  - relevanță practică

Un test poate fi semnificativ fără a fi important.


_C6 Teste pentru variabile categorice_ χ _² Fisher.nb_ **19**


  - **Semnificația Statistică (p)** : Ne spune doar dacă rezultatul este “real” (nu e hazard). În

cazul nostru, p > 0.5 (nesemnificativ), deci nu putem respinge independența.


  - **Relevanța Practică (Mărimea Efectului)** : Chiar dacă am fi avut p < 0.05, ar fi trebuit să

vedem cât de mare este diferența. Un eșantion de 10 000 de oameni poate arăta un _p_
foarte mic pentru o diferență de doar 1%, care în practică (ex: în HR sau medicină) nu
contează.

#### **◻ Regulă de aur:**


  - p-value măsoară **certitudinea** .


  - Coeficientul Phi sau Cramer’s V măsoară **puterea** legăturii.

## ◼ 4. Concluzie


Dacă rezultatul Fisher ar fi fost semnificativ, am fi concluzionat că există o legătură între
gen și promovare.


Deoarece p > 0.05, concluzionăm că diferențele observate în tabel (42 vs 58) sunt compatibile cu variația aleatoare și nu avem dovezi suficiente pentru a acuza o discriminare sau o
preferință bazată pe gen.


**20** _C6 Teste pentru variabile categorice_ χ _² Fisher.nb_

##### **7. Mărimea efectului: Semnificație vs. Relevanță**


Dacă p-value depinde enorm de mărimea eșantionului (un N foarte mare poate face ca
orice diferență minusculă să pară „semnificativă”), indicatorii mărimii efectului sunt independenți de N.

## ◼ 1. Coeficient φ (phi)


Standardul pentru tabele 2×2. Măsoară corelația dintre două variabile nominale.


Există două modalități principale de a calcula ϕ, în funcție de datele de care dispunem:

#### **◻ A. Din frecvențele celulelor (Formula directă)**


Dacă avem tabelul standard:


_O u t [_  _] =_


|Col1|Grup A|Grup B|Total|
|---|---|---|---|
|**Succes**|_a_|_b_|**_a_ +****_ b_**|
|**Eșec**|_c_|_d_|**_c_ +****_ d_**|
|**Total**|**_a_ +****_ c_**|**_b_ +****_ d_**|**_a_ +****_ b_ +****_ c_ +****_ d_**|








 - **Numărătorul** (a d - b c): Reprezintă determinantul matricei; dacă acesta este 0, vari
abilele sunt independente.


 - **Numitorul** : Este rădăcina pătrată a produsului tuturor marginalelor (totalurilor pe rânduri

și coloane).

#### **◻ B. Din statistica χ [2] (Formula de legătură)**

Dacă am calculat deja testul χ [2], ϕ se obține mult mai simplu:



ϕ =



χ [2]


_n_



Unde n este mărimea totală a eșantionului. Această formulă arată clar de ce ϕ elimină
influența lui _n_ asupra rezultatului.


_C6 Teste pentru variabile categorice_ χ _² Fisher.nb_ **21**

#### **◻ Interpretarea valorilor (Grila lui Cohen)**


În științele sociale și educație, se folosește adesea scara propusă de Jacob Cohen pentru
interpretarea magnitudinii efectului:


_O u t [_  _] =_


_O u t [_  _] =_

|Metodă|Rezultat|Ce indică semnul?|
|---|---|---|
|**Formula directă (ad - bc)**|- 0.1241|Direcția: Bărbații au succes mai<br>mic decât femeile în acest tabel.|
|**Formula**<br>**χ²**<br>**n**|+ 0.1241|Intensitatea: Măsoară doar<br>forța legăturii (fără direcție).|


|Valoare φ|Intensitatea asocierii|
|---|---|
|**0.10**|●Efect mic (asociere slabă)|
|**0.30**|●Efect mediu (asociere moderată)|
|**0.50**|●Efect mare (asociere puternică)|


## ◼ 2. V-ul lui Cramer


Extensia lui ϕ pentru tabele mai mari (r×c). În cazul 2×2, V este identic cu ϕ.


V-ul lui Cramer (V) este cea mai utilizată măsură a asocierii pentru tabelele de contingență
care depășesc formatul 2×2 (de exemplu, un tabel 3×4. În timp ce coeficientul ϕ este limitat
la două categorii per variabilă, Cramer’s V „normalizează” statistica χ [2] pentru a permite
compararea tabelelor de orice dimensiune.

#### **◻ 1. Definiție și Proprietăți**

Cramer’s V este o transformare a lui χ [2] care produce o valoare între 0 și 1.


  - 0 înseamnă independență totală (nicio legătură între variabile).


  - 1 înseamnă o asociere perfectă (cunoașterea unei variabile permite prezicerea exactă a

celeilalte).


Spre deosebire de ϕ (care poate fi negativ în calculul direct ad-bc), V-ul lui Cramer este
întotdeauna pozitiv, deoarece se bazează pe rădăcina pătrată a lui χ [2] .


**22** _C6 Teste pentru variabile categorice_ χ _² Fisher.nb_

#### **◻ 2. Formula de Calcul**


Formula generală pentru V-ul lui Cramer este:



_V_ =



χ [2]


_n_ ( _k_ - 1)



unde:


 - χ [2] : Statistica χ [2] calculată pentru tabel.


 - n: Dimensiunea totală a eșantionului (numărul total de observații).


 - k: Valoarea minimă dintre numărul de rânduri (r) și numărul de coloane (c). Mai exact, k =

min(r, c).


Factorul (k-1) reprezintă „gradul de libertate minim” al tabelului. Acesta are rolul de a scala
rezultatul astfel încât valoarea maximă posibilă să nu depășească niciodată 1, indiferent de
cât de mare este tabelul.

#### **◻ 3. Cazul particular 2×2 (Legătura cu ϕ)**

Dacă avem un tabel 2×2:

  - Numărul de rânduri r = 2.

  - Numărul de coloane c = 2.

  - Deci, k = min(2, 2) = 2.

  - Numitorul devine n × (2 - 1) = n.

În acest caz, formula devine:







Aceasta este exact formula pentru valoarea absolută a coeficientului ϕ. De aceea, pentru
tabele 2×2, cele două măsuri sunt identice.

#### **◻ 4. Interpretarea magnitudinii**

Interpretarea lui Cramer’s V depinde de „gradele de libertate” (dfsmall = _k_  - 1). Cu cât tabelul
este mai mare, cu atât pragurile pentru un „efect mare” sunt mai mici.


Pentru un tabel unde k-1 = 1 (cazul nostru 2×2):


 - 0.10: Efect mic


 - 0.30: Efect mediu


 - 0.50: Efect mare


_C6 Teste pentru variabile categorice_ χ _² Fisher.nb_ **23**

#### **◻ 5. Cod Wolfram Mathematica pentru Vizualizare**







|Element|Descriere|
|---|---|
|χ2|Statistica de test calculată|
|_n_|Eșantionul total|
|_r_|Numărul de rânduri|
|_c_|Numărul de coloane|
|_k_ min(_c_, _r_)|Dimensiunea minimă a tabelului|


**De ce îl folosim în loc de χ** **[2]** **?**


Într-o lucrare de licență sau un articol științific, este insuficient să spui că „există o legătură”
(p < 0.05). Vrem să știe dacă acea legătură este una puternică (V > 0.5) sau doar o curiozitate statistică slabă (V < 0.1).

## ◼ 3. Diferența Crucială dintre p-value și coeficienții φ și V : Semnificație vs. Relevanță


_O u t [_  _] =_






|Concept|Întrebare Cheie|Indicator Statistic|
|---|---|---|
|**Semnificație Statistică**|„Efectul observat<br>este rodul hazardului?”|_p_-_value_|
|**Relevanță Practică**|„Cât de puternică este<br>relația în realitate?”|φ (_Phi_) / _Cramer's V_|


**24** _C6 Teste pentru variabile categorice_ χ _² Fisher.nb_








|Prag|Interpretare|
|---|---|
|0.1|Efect Mic|
|0.3|Efect Mediu|
|0.5|Efect Mare|






 - Diferența dintre:


  - semnificație statistică

  - relevanță practică

#### **◻ Exemplul nostru:**


 - p > 0.5: Nu avem certitudinea că rezultatul nu este hazard.


 - ϕ = 0.124: Chiar dacă am fi avut mai multe date și rezultatul ar fi devenit „semnificativ”,
mărimea efectului (0.12) ne spune că asocierea dintre gen și promovare este **foarte**
**slabă** .


**Concluzie** : În raportarea finală, prezentăm întotdeauna ambele valori. Un _p_ mic fără un ϕ
substanțial este adesea doar un artefact al unui eșantion prea mare.


_C6 Teste pentru variabile categorice_ χ _² Fisher.nb_ **25**

##### **8. Interpretarea rezultatelor**

## ◼ 1. Marea Distincție: p-value ≠ importanță


Cea mai frecventă eroare în cercetare este confundarea semnificației statistice cu relevanța practică.


  - **Semnificația (** _**p**_ **)** ne spune doar dacă efectul este „real” (nu este hazard).


  - **Importanța (ϕ / V)** ne spune dacă efectul „contează” în lumea reală.

## ◼ 2. Capcane Frecvente în Interpretare

#### **◻ A. Paradoxul Eșantionului Mare**


Pe măsură ce _n_ (eșantionul) crește, eroarea standard scade. Într-un eșantion de 100 000
de persoane, o diferență infimă de 0.1% poate deveni p < 0.05.


  - **Sfat** : Cu cât eșantionul este mai mare, cu atât trebuie să fiți mai exigenți cu mărimea

efectului (ϕ), nu doar cu _p_ -value.

#### **◻ B. Confuzia Asociere vs. Cauzalitate**

Testele χ [2] și Fisher măsoară **asocierea**, nu **cauzalitatea** .


  - **Exemplu** : Chiar dacă am fi găsit o legătură între gen și promovare, nu putem afirma că

„genul cauzează promovarea”. Ar putea exista variabile ascunse (vechime, departament,
educație).

## ◼ 3. Raportarea Corectă (Standardul APA)


O raportare corectă trebuie să conțină întotdeauna trei elemente:


Pentru evaluarea relației dintre gen și succesul în promovare s-a utilizat **testul exact**
**Fisher**, alegere justificată de natura categorială a datelor și dimensiunea eșantionului.
Rezultatele indică o asociație **statistic nesemnificativă** (p = 0.174, bilateral), dublată de o
**mărime a efectului redusă** (ϕ = 0.124). Prin urmare, datele nu oferă dovezi suficiente
pentru a susține existența unei discriminări de gen în procesul de promovare în cadrul
grupului analizat.”


**26** _C6 Teste pentru variabile categorice_ χ _² Fisher.nb_


_O u t [_ _]_

|Element|Fragment din Text|Rol Didactic|
|---|---|---|
|**1. Testul**|Testul exact Fisher|Validarea alegerii metodei|
|**2. Semnificația**|p = 0.174|Probabilitatea de eroare (Hazardul)|
|**3. Efectul**|φ = 0.124|Importanța practică (Forța)|


## ◼ 4. Cod Wolfram Mathematica: Vizualizarea “Zonei de Decizie”


Urmează un grafic care ne reamintește cum să interpretăm poziționarea rezultatului în
contextul dovezilor.












- Capcane frecvente (pe scurt):


  - eșantioane mari → p mic

  - interpretări cauzale eronate


_C6 Teste pentru variabile categorice_ χ _² Fisher.nb_ **27**

##### **9. Activități de laborator (obligatorii)**

## ◼ 1. Analiză pe date reale


   - Construirea tabelului de contingență

   - Calcul χ² și Fisher

## ◼ 2. Simulări

   - Generarea de tabele sub H₀

   - Distribuția statisticii χ²

## ◼ 3. Implementări paralele


   - Wolfram Mathematica

   - Python (scipy.stats, pandas)


**28** _C6 Teste pentru variabile categorice_ χ _² Fisher.nb_

##### **10. Concluzii**


La finalul acestei teme despre testarea ipotezelor stiatistice, posedăm abilitățile necesare
pentru a naviga cu rigoare prin procesul de analiză a datelor nominale.

## **◼ Competențe Dobândite**


  - **Diagnosticare Metodologică** : Putem decide critic între utilizarea **Testului χ** **[2]** (eșan
tioane mari) și **Testului Exact Fisher** (eșantioane mici/frecvențe reduse).


  - **Formulare Riguroasă** : Suntem capabili să translatăm o întrebare de cercetare într-un

set de **ipoteze statistice** ( _H_ 0 vs _H_ 1) corect definite.


  - **Interpretare Duală** : Putem stăpâni distincția dintre semnificația statistică (validată prin p
value) și relevanța practică (măsurată prin ϕ sau V-Cramer).


_O u t [_  _] =_

|OBIECTIV|ABILITATE SPECIFICĂ|
|---|---|
|**Identificare**|Alegerea testului optim în funcție de N și frecvențe.|
|**Formulare**|Definirea H0 (independență) și H1 (asociere).|
|**Interpretare**|Explicarea p-value și a coeficientului φ.|
|**Raportare**|Sinteza rezultatelor conform standardelor APA.|



**Standardul APA** (creat de American Psychological Association) este cel mai utilizat set de
reguli pentru redactarea documentelor academice, în special în psihologie, educație și
științele sociale. Există o **regulă de aur** în statistică: _valorile statistice se scriu cu litere_
_cursive_ ( _italice_ ), iar zecimalele se rotunjesc de obicei la două sau trei cifre.


_C6 Teste pentru variabile categorice_ χ _² Fisher.nb_ **29**

##### **Setări**

## **◼ Setări notebook** **◼ Setări celule**




















