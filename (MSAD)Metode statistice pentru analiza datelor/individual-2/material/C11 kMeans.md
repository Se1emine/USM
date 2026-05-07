# **k-Means Algorithm**

_**Presenter**_


**Valeriu Ungureanu**


_**Data**_


_**Wednesday, 1 April 2026**_


_**Moldova State University**_


_Statistical Methods for Data Analysis_


**2** _C11 kMeans.nb_

##### **1. Învățarea nesupervizată. Algoritmul k-Means** **◼ Clusterizarea** **◼ Normă, distanță și similaritate** **◼ Algoritmul k-Means**


_C11 kMeans.nb_ **3**

##### **2. Clustere și clusterizare**

## **Algoritmul k-Means pe scurt**


Algoritmul sau metoda k-Means este un algoritm de învățare nesupravegheată utilizat
pentru clusterizare (gruparea datelor). Acesta împarte setul de date în 𝑘 grupuri/clustere, în
care fiecare punct/exemplar de date aparține celui mai apropiat cluster, definit prin centrul
său, numit centroid.

#### **◻ Pașii principali ai algoritmului k-Means**
##### ◼ Inițializare : Se selectează în mod aleator 𝑘 centre (centroizi) pentru clustere. ◼ Atribuire : Fiecare punct/exemplar de date din setul de date este alocat celui mai apropiat centroid, formând astfel clustere provizorii. ◼ Actualizare : Pentru fiecare cluster, se calculează un nou centroid ca medie a tuturor punctelor de date din acel cluster. ◼ Iterare : Pașii de asignare și actualizare se repetă până când centroizii nu se mai schimbă sau schimbările sunt minime, indicând că algoritmul a realizat convergența la un set de centroizi ficși.

#### **◻ Avantajele și Dezavantajele**


**Avantaje** : Este simplu de implementat, scalabil pentru seturi de date mari și convergența
este adesea rapidă.


**Dezavantaje** : Alegerea inițială a centroizilor influențează rezultatul final, poate conduce la
clustere de calitate scăzută pentru date complexe, și necesită să știm numărul 𝑘 de clustere în avans.

#### **◻ Aplicarea practică**

Aplicarea cu succes a algoritmului k-Means cere inerent calcularea distanțelor dintre
puncte (exemplare de date). În funcție de problema concretă și de caracteristicile datelor,
se aleg și distanțele potrivite.

## **Noțiunea de normă. Distanța standard asociată normei**


În matematică, norma și distanța sunt concepte fundamentale, mai ales în analiza funcțională, geometrie și topologie. Un rol însemnat aceste concepte îl au și în învățarea automată.
Să examinăm mai întâi conceptul de normă.


**4** _C11 kMeans.nb_


Norma este o funcție care atribuie un număr real unui element dintr-un spațiu vectorial și
satisface anumite proprietăți. Ea măsoară _„mărimea”_ sau _„lungimea”_ unui vector.


**Definiție** . Fie 𝑉 un spațiu vectorial pe un corp (de obicei  sau ). Vom numi normă ∥⋅∥ pe
𝑉 o funcție ∥𝑣∥: 𝑉→ [0, ∞) care satisface următoarele condiții pentru orice vectori 𝑢, 𝑣 ∈ 𝑉, și
scalari 𝛼 ∈  (sau ):


  - **Pozitivitate** : ∥𝑣∥ ≥ 0, iar ∥𝑣∥ = 0 dacă și numai dacă 𝑣 = 0.


  - **Omogenitate** : ∥𝛼 𝑣∥ = ∣𝛼∣∥𝑣∥.


  - **Inegalitatea triunghiului** : ∥𝑢 + 𝑣∥ ≤ ∥𝑢∥ + ∥𝑣∥.


Exemple de norme:

#### **◻ Norma Euclid pentru spațiul  [n]**


n
2

x2 =  xi,

i=1


unde x ∈  [n] .














_C11 kMeans.nb_ **5**












#### **◻ Norma Manhattan**

unde x ∈  [n] .



n

l1 (x) = x1 =  xi



i=1










**6** _C11 kMeans.nb_














#### **◻ Norma Chebyshev (supremum, maximum)**

l∞ (x) = x∞ = max xi
i

unde x ∈  [n] .


_C11 kMeans.nb_ **7**









În cazul unui spațiu vectorial dotat cu o normă, distanța între două puncte 𝑢
și 𝑣 este definită prin norma diferenței dintre ele:


𝑑(𝑢, 𝑣) = ∥𝑢                     - 𝑣∥


Aceasta este distanța standard definită de norma asociată.

## **Spații metrice. Clusterizare**


**Definiție** . Se numește distanță (metrică) într-o mulțime X orice funcție nenegativă d : X×X →
 care posedă următoarele proprietăți:

##### 1. d(x, y) = 0 dacă și numai dacă x = y; 2. d(x, y) = d(y, x) pentru orice x, y ∈ X (simetria); 3. d(x, z) ⩽ d(x, y) + d(y, z) pentru orice x, y, z ∈ X (inegalitatea triunghiului).


**Remarcă** . Din inegalitățile 1-3 rezultă că funcția d : X × X →  este nenegativă.


Într-adevăr, 0 = d(x, x) ⩽ d(x, y) + d(y, x) = 2d(x, y).


Prin urmare, în definiția distanței condiția de nenegativitate poate fi omisă.


**8** _C11 kMeans.nb_


**Definiție** . Se numește **spațiu metric** orice mulțime nevidă în care este definită o distanță.
O definiție echivalentă: se numește spațiu metric o structură matematică formată dintr-o
mulțime de elemente și o funcție numită metrică, care măsoară distanța dintre elementele
mulțimii, adică e definită de o pereche (X, d)


Așadar, spațiul metric poate fi notat fie ( _X_, d), fie _Xd_ .


**Definiție** . Numim _**clusterizare**_ procesul de partiționare a unui set de date în subseturi
distincte numite clustere.


**Definiție** . Numim _**cluster**_ un grup de date care sunt similare între ele din punctul de vedere
al caracteristicilor, fiind apropiate spațial într-un anumit model de date, dar și destul de
distincte pentru a se deosebi de datele din alte clustere.


_C11 kMeans.nb_ **9**

##### **3. Distanță și similaritate**

## **◼ Diverse funcții de distanță**

#### **◻ Distanța Euclidiană**


n

d (x, y) =  (xi - yi) [2]


i=1


Este cea mai utilizată metrică în kMeans și este adecvată pentru date omogene care se
grupează în clustere de forme sferice în spațiul caracteristicilor.



In[25]:=


In[21]:=


Out[21]=



**Manipulate[Plot3D[dEuclid[{x1,** **x2},** **{y1,** **y2}],** **{x1,** **-3,** **3},** **{x2,** **-3,** **3}],**
**{{y1,** **0},** **-3,** **3},** **{{y2,** **0},** **-3,** **3}]**










**10** _C11 kMeans.nb_


In[22]:=





Out[22]=








#### **◻ Distanța Manhattan**



n

d (x, y) =  xi - yi



i=1


Aceasta este suma distanțelor absolute pe fiecare dimensiune. Funcționează bine în
cazurile în care datele au clustere mai dispersate și sunt mai puțin sensibile la zgomot.



In[27]:=










_C11 kMeans.nb_ **11**


In[10]:=





Out[10]=




**12** _C11 kMeans.nb_


In[14]:=





Out[14]=








#### **◻ Distanța Minkowski** **◻ Distanța Hellinger** **◻ Distanța Cosinusului** **◻ Distanța Mahalanobis** **◻ Distanța Hamming** **◻ Distanța Chebyshev** **◻ Distanța Canberra** **◻ Distanța Bray-Curtis** **◻ Distanța Jaccard** **◻ Distanța Corelativă** **◻ Distanța Dice** **◻ Distanța Sørensen-Dice**


_C11 kMeans.nb_ **13**

#### **◻ Distanța Chi-pătrat** **◻ Distanța Bhattacharyya** **◻ Distanța Kullback-Leibler** **◻ Distanța Logaritmică** **◻ Distanța Levenstein**

Reprezentarea formulelor distanțelor sub formă de tabel oferă o imagine de ansamblu
asupra lor.


**14** _C11 kMeans.nb_

## **◼ Noțiunea de similaritate vs cea de distanță**


Există o diferență fundamentală între măsurile de distanță și cele de similaritate, deși
ambele se utilizează cu succes în învățarea automată.


Distanța măsoară cât de diferite sunt două obiecte sau seturi de date. Cu cât valoarea
distanței este mai mare, cu atât cele două obiecte sunt mai diferite. Distanțele sunt valori
nenegative, iar distanța 0 indică identitatea completă (dacă există identitate).


Similaritatea, pe de altă parte, măsoară gradul de asemănare dintre două obiecte. Cu cât
valoarea similarității este mai mare, cu atât cele două obiecte sunt mai asemănătoare.
Similaritățile sunt, de obicei, normalizate în intervalul [0, 1] sau [-1, 1], unde o valoare mai
apropiată de 1 indică o asemănare mai mare.


Adesea, similaritatea poate fi derivată dintr-o distanță printr-o transformare inversă:


**1**
**similaritatea =**

**1 + distanța**


Această relație permite interpretarea similarității și distanței în mod echivalent, dar transformate, pentru a se potrivi tipului de analiză dorit.


_C11 kMeans.nb_ **15**

##### **4. Algoritmul k-Means în profunzime**

## ◼ Formularea matematică a problemei


Pentru un set S de puncte/observații/exemplare _x_ _[i]_ ∈ [n], _i_ = 1, ..., _m_, unde fiecare punct
este un vector n-dimensional, clusterizarea k-Means partiționează cele m puncte în k (≤ n)
clustere/subseturi

_C_ = { _C_ 1, _C_ 2, ..., _Ck_ }, _S_ = ⋃ _ki_ =1 _Ci_,


astfel ca să minimizeze suma pătratelor, adică dispersia. Formal, obiectivul constă în
aflarea:



_k_




_k_
 _Ci_  Var _Ci_



arg min 
_C_



_i_ =1



_x_ ∈ _Ci_



 _x_ - μ _i_  [2] = arg min 
_C_



_i_ =1



unde μ _i_ este media (centroidul) punctelor din _Ci_, adică:



 _x_,

_x_ ∈ _Ci_



μ _i_ =




 _Ci_ 



1



 _Ci_  este dimensiunea _Ci_, iar norma, de regulă, este cea Euclidiană.


Problema de mai sus este echivalentă cu minimizarea devierelor pătratice ale punctelor din
același cluster, adică cu următoarea problemă:



_k_ 1



  _x_ - _y_  [2]

_x_, _y_ ∈ _Ci_



arg min 
_C_




 _Ci_ 



_i_ =1



Echivalența se deduce din identitatea:


 _Ci_   _x_           - μ _i_  [2] =

_x_ ∈ _Ci_



1



  _x_ - _y_  [2]

_x_, _y_ ∈ _Ci_




2



Deoarece varianța/dispersia totală este constantă, aceasta este echivalent cu maximizarea
sumei devierilor pătrate dintre puncte în diferite clustere.

## ◼ Scurt istoric


Termenul „k-Means” a fost folosit pentru prima oară de către **James MacQueen** în **1967**,
deși **ideea** de bază a fost sugerată anterior de către Hugo Steinhaus încă în **1956** .


**16** _C11 kMeans.nb_


Algoritmul standard a fost propus inițial de către **Stuart Lloyd** de la Bell Labs în **1957** în
calitate de tehncă pentru manipularea modulațiilor prin coduri de impulsuri, deși oficial nu a
fost publicat până în 1982 în calitate de articol în jurnal științific.


În **1965**, **Edward W. Forgy** a publicat în esență aceeași metodă, din care motiv algoritmul
este uneori denumit algoritmul **Lloyd-Forgy** .

## ◼ Algoritmul k-Means standard („naiv”)


Cel mai comun algoritm k-Means folosește   - tehnică de rafinare iterativă. Datorită
ubicuității sale, este adesea numit „algoritmul k-means”, dar și algoritmul Lloyd, în special
în comunitatea informatică. Uneori este denumit și „k-means naiv”, deoarece există alternative mult mai rapide.



Fiind dată o mulțime inițială de _k_ medii μ11, μ21, ..., μ _k_ 1, algoritmul continuă prin alternarea

a doi pași:



1, ..., μ _k_



Fiind dată o mulțime inițială de _k_ medii μ1



1, μ2



**1.** **Pasul de atribuire** : Se atribuie fiecare observație clusterului cu cea mai apropiată medie:
cea cu cea mai mică distanța euclidiană la pătrat. (Matematic, aceasta înseamnă partiționarea observațiilor în corespundere cu de diagrama Voronoi generată de medii.)

_Cit_ =  _xp_ :  _xp_              - μ _it_  [2] ≤ _xp_              - μ _jt_  [2], ∀ _j_, 1 ≤ _j_ ≤ _k_ ,


unde fiecare _xp_ este atribuit exact doar unui cluster din _C_ _[t]_, chiar dacă poate fi atribuit
m a i
multor clustere.


**2.** **Pasul de actualizare** : Se recalculează mediile (centroizii) pentru observațiile atribuite

fiecărui cluster.



 _x_ _j_

_x_ _j_ ∈ _Ci_ _t_



μ _it_ +1 =




 _Cit_ 



1



**Remarcă** . Funcția obiectiv în k-Meansi suma de pătrate în cluster. După fiecare iterație,
valoarea acestei sume scade și astfel se obține - secvență monotonă nenegativă
descrescătoare. Acest lucru garantează că algoritmul k-Mean întotdeauna converge, dar
nu neapărat către optimul global.


Algoritmul oprește execuția, când atribuirile nu mai schimbă valorile. Algoritmul nu găsește
garantat clusterizarea optimă.


Algoritmul este adesea prezentat ca atribuind elemente celui mai apropiat cluster în funcție
de distanță. Utilizarea unei alte funcții de distanță decât cea euclidiană (pătratată) poate să
împedice convergența algoritmului. Au fost propuse diferite modificări ale k-Means, pentru
a permite utilizarea altor măsuri de distanță.


_C11 kMeans.nb_ **17**

## ◼ Codul algoritmului în limbajul Wolfram


**◻** **Clusterizare simpla k-Means**














**18** _C11 kMeans.nb_


**◻** **Clusterizare animată k-Means**

Out[18]=


























_C11 kMeans.nb_ **19**

##### **5. Complexitatea algoritmului k-Means**

## ◼ Metode de inițializare


Metodele de inițializare utilizate frecvent în algoritmul k-means sunt **Forgy** și **Random**
**Partition** .


**Metoda Forgy** selectează aleatoriu 𝑘 observații din setul de date și le utilizează drept
centroizi inițiali ai clusterelor.


În schimb, **metoda Random Partition** atribuie inițial fiecărei observații un cluster ales
aleator. Ulterior, se execută pasul de actualizare, în care se calculează media punctelor din
fiecare cluster, aceste medii devenind **centroizii inițiali** .


Cele două metode conduc, de regulă, la distribuții diferite ale centroidelor inițiale. Metoda
**Forgy** tinde să plaseze centroizii inițiali mai răspândit în spațiul datelor, deoarece aceștia
sunt puncte reale din setul de date. În schimb, metoda **Random** **Partition** produce frecvent
centroizi situați aproape de centrul geometric al setului de date, deoarece fiecare cluster
conține inițial puncte distribuite aleator în întregul spațiu.


Conform lui Hamerly și colaboratorii, metoda Random Partition este în general preferată
pentru algoritmi precum k-harmonic means sau fuzzy k-means, în timp ce metoda Forgy
este mai potrivită pentru algoritmul standard k-means și pentru proceduri de tip ExpectationMaximization (EM).


Totuși, un studiu experimental amplu realizat de Celebi și colaboratorii arată că metodele
clasice de inițializare — precum Forgy, Random Partition sau Maximin — pot produce
frecvent rezultate de calitate modestă. În schimb, metoda propusă de **Bradley și Fayyad**
prezintă performanțe consistente, situându-se adesea în „cel mai bun grup” de rezultate, iar
algoritmul **k-means++** oferă în general o performanță bună și stabilă.


Este important de remarcat că algoritmul k-means nu garantează convergența către optimul global. Rezultatul final depinde de pozițiile inițiale ale centroidelor. Din acest motiv, în
practică algoritmul este rulat de mai multe ori cu inițializări diferite, iar soluția finală este
aleasă dintre rezultatele obținute.


Deși algoritmul este, în general, foarte rapid, există și cazuri teoretice în care convergența
poate fi extrem de lentă. Anumite configurații de puncte, chiar și în două dimensiuni, pot
conduce la un timp de convergență **exponențial**, de ordinul 2 [Ω(] _[n]_ [)] . Totuși, astfel de situații
nu apar de obicei în aplicațiile practice, fapt confirmat de analizele privind **timpul de rulare**
**netezit (smoothed runtime)** al algoritmului k-means, care este **polinomial** .


Din punct de vedere conceptual, algoritmul poate fi interpretat și ca o formă particulară a
metodei **Expectation–Maximization** **(EM)** . În această perspectivă, **pasul** **de** **atribuire**


**20** _C11 kMeans.nb_


(assignment step), în care fiecare punct este asociat cu cel mai apropiat centroid, corespunde **pasului de așteptare (E-step)**, iar **pasul de actualizare** (update step), în care se
recalculează centroizii ca medii ale clusterelor, reprezintă **pasul de maximizare (M-step)** .
Astfel, algoritmul k-means poate fi privit ca o variantă simplificată a algoritmului **general-**
**ized Expectation–Maximization** .

## ◼ Complexitatea algoritmului k-Means


Găsirea soluției optime pentru problema de clusterizare k-Means pentru observații în dimensiuna n este:


  - NP-hard în _R_ _[n]_ chiar și pentru două clustere,


  - NP-hard pentru un număr general de clustere k chiar și în plan,


  - dacă k și n sunt fixe, problema poate fi rezolvată exact în timp _O_  _m_ _[n k]_ [+][1] , unde m este

numărul de entități care trebuiesc clusterizate.


Astfel, în general sunt utilizați o varietate de algoritmi euristici, cum ar fi algoritmul lui Lloyd
prezentat mai sus.


Durata de rulare a algoritmului Lloyd (și a majorității variantelor) este O(m k n i) unde:


  - m este numărul de vectori n-dimensionali (de grupat)


  - k numărul de clustere


  - i numărul de iterații necesare până la convergență.


Pe datele care au o structură de clustere, numărul de iterații până la convergență este
adesea mic, iar rezultatele se îmbunătățesc ușor după primele zece iterații. Prin urmare,
algoritmul lui Lloyd este adesea considerat a fi de complexitate „liniară” în practică, deși în
cel mai rău caz este superpolinomial atunci când se execută până la convergență.


Algoritmul lui Lloyd constituie abordarea standard pentru problema de clusterizare. Cu
toate acestea, consumă mult timp pentru calcularea distanțelor dintre fiecare dintre cele k
centroide și cele m puncte de date. Deoarece punctele rămân de obicei în aceleași grupuri
după câteva iterații, o mare parte din această muncă este inutilă, ceea ce face ca implementarea naivă să fie foarte ineficientă. Unele implementări folosesc memorarea în cache
și inegalitatea triunghiului pentru a crea limite și pentru a accelera algoritmul lui Lloyd.

## ◼ Numărul optim de clustere


Găsirea numărului optim de clustere (k) pentru algoritmul k-Means este un pas crucial
pentru asigurarea că rezultatele clusterizării sunt semnificative și utile. Există mai multe
tehnici pentru a determina un număr adecvat de clustere:


_C11 kMeans.nb_ **21**


  - **Elbow method** (metoda cotului): Această metodă implică reprezentarea grafică a vari
ației în funcție de numărul de clustere și alegerea cotului curbei ca număr de clustere de
utilizat. Noțiunea de „cot” nu este bine definită și se știe că metoda nu este de încredere.


  - **Silhouette** : analiza siluetei măsoară calitatea grupării și oferă o perspectivă asupra dis
tanței de separare dintre clusterele rezultate. Un scor de siluetă mai mare indică faptul că
obiectul este bine potrivit cu propriul său cluster și slab potrivit cu clusterele învecinate.


  - **Gap statistic** (statistica decalajului): statistica decalajului compară totalul din variația

intra-cluster pentru diferite valori ale lui k cu valorile așteptate ale acestora sub distribuția
de referință nulă a datelor. Valoarea optimă optimă pentru k coincide cu valoarea care
asigură cea mai mare statistică de decalaj.


  - **Indicele Davies-Bouldin** : este o măsură a cât de multă separare există între clustere.
Valorile mai mici ale indicelui Davies-Bouldin indică un model cu o mai bună separare.


  - **Indicele Calinski-Harabasz** : evaluează clusterele pe baza compactității și separării lor.
Indicele este calculat folosind raportul dintre varianța dintre clustere și varianța în interiorul clusterului, cu valori mai mari indicând clustere mai bine definite.


  - **Indicele Rand** : calculează proporția de concordanță între două clustere, luând în consid
erare ambele perechi de elemente care sunt corect alocate aceluiași cluster sau diferitor
clustere. Valorile mai mari indică o asemănare mai mare și o calitate mai bună a grupării.
Pentru a oferi o măsură mai precisă, Indicele Ajustat Rand Index (ARI), introdus de
Hubert și Arabie în 1985, corectează indicele Rand prin ajustarea pentru similitudinea
așteptată a tuturor perechilor ca funcție de șansă.

## ◼ Codul în limbajul Python


**22** _C11 kMeans.nb_

##### **Setări**

## ◼ Setări notebook ◼ Setări celule


