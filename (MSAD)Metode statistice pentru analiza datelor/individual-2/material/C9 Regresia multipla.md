# **Multiple Linear Regression**

_**Presenter**_


**Valeriu Ungureanu**


_**Data**_


_**Thursday, 26 March 2026**_


_**Moldova State University**_


_Statistical Methods for Data Analysis_


**2** _C9 Regresia multipla.nb_

### **1. Regresia liniară multiplă**

## **Introducere: Dincolo de Regresia Simplă**


În regresia simplă, aveam    - dreaptă. În **regresia** **liniară** **multiplă** ( _**множественная**_
_**линейная регрессия**_ ), avem un **hiperplan** .


**Concept** : Lumea reală este complexă. Un singur predictor (ex: suprafața casei) rareori
explică totul. Avem nevoie de mai mulți factori (ex: vechime, zonă, număr de camere).


**Efectul „Ceteris Paribus”** („celelalte lucruri rămânând neschimbate”): Cum se schimbă _y_
dacă modificăm un predictor, păstrându-i pe ceilalți constanți?


   - **De la linie la plan** : În regresia simplă aveam y = f(x). În regresia multiplă avem

_y_ = _f_ ( _x_ 1, _x_ 2, ...).

   - **Obiectiv** : Izolarea efectului unei variabile în timp ce restul sunt menținute constante

(Ceteris Paribus).

   - **Demonstrație vizuală** : Generăm un nor de puncte  [3] și un plan care să le „asculte”.


_C9 Regresia multipla.nb_ **3**

## **Obiective Conceptuale**

   - **Extinderea Modelului** : Să explicăm tranziția de la regresia simplă (linie în  [2] ) la cea
multiplă (hiperplan în  [n] ).

   - **Principiul Ceteris Paribus:** Să interpretăm coeficienții parțiali de regresie ca fiind
contribuția unică a fiecărui predictor, controlând influența celorlalți (cum se schimbă
variabilia dependentă dacă modificăm un predictor, păstrându-i pe ceilalți constanți?).

   - **Logica Ajustării** : Să înțelegem de ce _R_ [2] ajustat este o măsură mai onestă a calității
modelului decât _R_ [2] standard.

   - **Executăm** **și** **Validăm** : Să aplicăm modelul ANOVA One-Way și să verificăm
ipotezele critice (normalitate, omogenitatea varianțelor/homoscedasticitate).


**4** _C9 Regresia multipla.nb_


   - **Interpretăm Inferențial** : Să extragem concluzii statistice și contextuale din tabelul
ANOVA și testele Post-Hoc.

## **Obiective Tehnice & Diagnostică**


   - **Detectarea Multicoliniarității** : Să identificăm situațiile în care predictorii sunt prea
corelați folosind indicatorul **VIF** ( **V** ariance **I** nflation **F** actor, Фактор инфляции
дисперсии).

   - **Validarea Ipotezelor:** Să diagnosticăm sănătatea modelului prin analiza reziduurilor

(normalitate, homoscedasticitate) și identificarea punctelor de influență ( **Distanța**
**Cook** ).

   - **Selecția** **Variabilelor** : Să înțelegem strategiile de optimizare a modelului (Step
wise/Backward/Forward) pentru a evita supra-ajustarea (overfitting).

## **Obiective Practice**


   - **Modelare Robustă** : Să utilizăm funcția LinearModelFit pentru a construi modele pe
date reale.

   - **Vizualizare Avansată** : Să generăm și să manipulăm planuri de regresie  [3] pentru a
comunica vizual rezultatele analizei.

   - **Predicție** : Să folosim modelul estimat pentru a genera previziuni punctuale și intervale de încredere.

Dacă **ANOVA** ne-a învățat cum să comparăm grupuri, **Regresia Multiplă** ne învață cum să
**modelăm complexitatea** . Nu mai întrebăm doar dacă un factor contează, ci cât de mult
contează în prezența altora.


_C9 Regresia multipla.nb_ **5**

### **2. Modelul Matematic și Interpretarea**


_y_ = β0 + β1 _x_ 1 + β2 _x_ 2 + ... + β _k xk_ + ε


  - β0 ( **Intercepția** ): Valoarea lui _y_ când toți predictorii sunt zero.


  - β _i_ ( **Coeficienți parțiali** ): Contribuția specifică a variabilei _xi_ la _y_, controlând influența

celorlalte variabile. β _i_ nu mai este doar o pantă, ci contribuția marginală.

**Exemplu** : Dacă _x_ 1 este suprafața și β1 = 500, înseamnă că fiecare metru pătrat adăugat crește prețul cu 500 unități, presupunând că vechimea și locația rămân aceleași.

  - **Eroarea** (ε): Diferența dintre realitate și model (zgomotul).


**6** _C9 Regresia multipla.nb_

### **3. Estimarea și Evaluarea Modelului: R [2] vs R [2] Ajustat**


  - **Metoda** **Celor** **Mai** **Mici** **Pătrate** **(OLS)** : Minimizarea sumei pătratelor reziduurilor în

spațiul n-dimensional.


  - **Problema cu coeficientul de determinare** _R_ [2] : Dacă adăugăm variabile „gunoi” (ex:
prețul cafelei în Brazilia) într-un model despre prețul locuințelor, _R_ [2] va crește artificial.


  - **Soluția** : _R_ [2] **Ajustat** : Penalizează adăugarea de variabile care nu îmbunătățesc modelul.


Pentru a înțelege de ce 𝑅 [2] ajustat este mai „onest”, trebuie să plecăm de la o limitare
fundamentală a lui 𝑅 [2] standard:


**1. Problema lui** 𝑅 **[2]** **standard**

𝑅 [2] = 1 - [SS][rez]
SStot

   - 𝑅 [2] măsoară proporția din variația variabilei dependente explicată de model.

   - Problema critică: 👉 𝑅 [2] nu scade niciodată când adăugăm variabile explicative noi.

Chiar dacă adaugăm:


   - variabile irelevante,

   - zgomot aleator,

   - sau predictori fără semnificație statistică,

𝑅 [2] va crește sau va rămâne la fel.


**Consecință** : Modelul pare „mai bun” doar pentru că este mai complex, nu pentru că este
mai informativ.


**2. Corecția introdusă de** 𝑅 **[2]** **ajustat**

𝑅2adj = 1 - 1 - 𝑅2 _n_                               - _n p_                               - 1 - 1


unde:


𝑛 = numărul de observații


𝑝 = numărul de variabile explicative


_C9 Regresia multipla.nb_ **7**


**3. De ce este „mai onest”**


(a) Penalizează complexitatea inutilă




- Dacă adaugăm o variabilă care nu aduce informație reală, termenul _[n]_ [-][1]



2

- ⇒ 𝑅adj poate scădea




[-]

_n_ - _p_ -1 [ crește]



Spre deosebire de 𝑅 [2], modelul este „taxat” pentru overfitting.


(b) Echilibrează bias–variance trade-off (compromisul bias-varianță)


Более сложные модели уменьшают смещение, но увеличивают дисперсию,
иллюстрируя компромисс между смещением и дисперсией.

  - 𝑅 [2] : favorizează modele supracomplexe (overfitting)

2

  - 𝑅adj: preferă modele parsimonioase (парсимоничные модели, Occam: dintre două

modele care explică datele la fel de bine, îl alegem pe cel mai simplu)

În termeni statistici: promovează generalizarea, nu doar potrivirea pe eșantion


(c) Permite comparații corecte între modele


Dacă avem:


  - Model A: 3 variabile

  - Model B: 10 variabile

𝑅 [2] va favoriza aproape întotdeauna Modelul B

𝑅2adj poate arăta că Modelul A este mai bun


(d) Reflectă mai bine contribuția marginală a predictorilor


**4. Intuiția esențială**

  - 𝑅 [2] : „Cât de bine explic datele?”

2

  - 𝑅adj: „Cât de bine explic datele raportat la cât de complicat este modelul?”


**5. Concluzie**

𝑅2adj este o măsură mai onestă deoarece:


introduce o penalizare explicită pentru dimensionalitatea modelului, evaluând performanța explicativă în raport cu complexitatea acestuia și reducând astfel riscul de
supraînvățare (overfitting).

- **Testul F Global** : Verifică dacă modelul, în ansamblul său, este mai bun decât o simplă

medie ( _H_ 0 : β1 = β2 = … = β _k_ = 0).


**8** _C9 Regresia multipla.nb_








_C9 Regresia multipla.nb_ **9**

### **4. Inamicul Tăcut: Multicoliniaritatea**


Apare atunci când variabilele explicative sunt puternic corelate între ele (ex: greutatea în kg
și greutatea în lbs).


  - **Problema** : Când _x_ 1 și _x_ 2 „spun aceeași poveste” (ex: numărul de calorii și greutatea

porției).

### **◼ Factorul de inflație a varianței**


Factorul de inflație a varianței ( **V** ariance **I** nflation **F** actor, VIF, Фактор инфляции
дисперсии) este o măsură standard pentru detectarea multicoliniarității într-un model de
regresie liniară.


**1. Definiția formală**


Pentru o variabilă explicativă _x_ _j_, VIF este:

VIF _j_ = 1 2
1 - _R_ _j_


unde:


2

  - 𝑅 _j_ = coeficientul de determinare din regresia auxiliară:

  - 𝑋 _j_ ∼ _X_ 1, ..., _X_ _j_ -1, _X_ _j_ +1, ..., _Xn_


**2. Intuiție**

𝑅2 _j_ măsoară cât de bine este explicată 𝑋 _j_ de celelalte variabile:


2

  - dacă 𝑅 _j_ → 1 → coliniaritate puternică ⇒ VIF _j_ → ∞


**3. Algoritmul de calcul (pas cu pas)**

Pentru fiecare variabilă 𝑋 _j_ :


**Pasul 1**


Construim regresia auxiliară:


_x_ _j_ = β0 + ∑ _k_ ≠ _j_ β _k xk_ + ε


**Pasul 2**

Calculăm 𝑅2 _j_


**10** _C9 Regresia multipla.nb_


**Pasul 3**


Aplicăm formula:



VIF _j_ = 1



2



1 - _R_ _j_



_O u t [_  _] =_



**4. Interpretare standard**

|VIF|Interpretare|
|---|---|
|1|fără coliniaritate|
|1–5|moderată|
|5–10|problematică|
|>10|severă (model instabil)|



Dacă o variabilă explicativă poate fi aproape determinată de celelalte, modelul nu mai
poate separa contribuțiile individuale ale predictorilor, iar estimările coeficienților devin
instabile și imprecise.


**5. Exemplu numeric**

Să presupunem: 𝑅2 _j_ =0.8



Atunci: VIF _j_ = 1



1 1
2 [=] 1 - 0.8 [=] 0.2 [=][ 5]



1 - _R_ _j_



⇒ coliniaritate semnificativă


**6. Formulare echivalentă (importantă teoretic)**

VIF apare în varianța estimatorului coeficientului 𝛽 []











_j_ [ în metoda celor mai mici pătrate:]







Deci: Var(𝛽 []



_j_ [)] [∝][ VIF] _[j]_



adică, varianța estimatorului coeficientului 𝛽 [] _j_ [ este direct proporțională cu factorul de inflație]

a varianței VIFj.


Prin urmare, VIF măsoară inflarea varianței coeficientului datorată coliniarității


_C9 Regresia multipla.nb_ **11**


_O u t [_ _]_

|Variabilă|VIF|Interpretare|
|---|---|---|
|X1|173.31|severă (model instabil)|
|X2|639.16|severă (model instabil)|
|X3|341.43|severă (model instabil)|
|X4|7.17|problematică|
|X5|3.02|moderată|
|X6|1.06|moderată|



Dacă o variabilă explicativă poate fi aproape determinată de celelalte, modelul nu mai
poate separa contribuțiile individuale ale predictorilor, iar estimările coeficienților devin
instabile și imprecise. Mici variații în date pot conduce la variații semnificative ale variabilei
dependente. Ne reamintim ca explicație formula exactă de calcul a coeficienților de
regresie:

β [] =  _X_ _[T]_ _X_  [-][1] _X_ _[T]_ _y_


Așadar:


_O u t [_  _] =_


  - **Detectare: VIF**

|VIF|Interpretare|
|---|---|
|1.00|fără coliniaritate|
|2.78|moderată|
|6.34|problematică|
|15.20|severă (model instabil)|



   - VIF > 10 indică faptul că varianța coeficientului este de 10 ori mai mare din cauza
corelației cu ceilalți predictori.

  - **Efect** : Coeficienții devin instabili, iar erorile standard explodează.


  - **Detectare: VIF**


   - _VIF = 1_ : Nicio corelație.

   - VIF > 5 sau 10: Problemă gravă! Variabila trebuie eliminată sau combinată.


**12** _C9 Regresia multipla.nb_

### **5. Selectarea Variabilelor**


Cum alegem „combinația ideală” de predictori?


Selecția variabilelor explicative reprezintă un pas esențial în construcția unui model de
regresie, întrucât influențează direct atât performanța predictivă, cât și interpretabilitatea
modelului. În practică, sunt utilizate mai multe strategii standard:


**1.** **Forward Selection** : Se pornește de la un model fără predictori și se adaugă iterativ

variabila care aduce cea mai mare îmbunătățire a modelului (de exemplu, în termeni de
AIC (Akaike Information Criterion) sau semnificație statistică).


**Akaike Information Criterion** (AIC) este un criteriu statistic utilizat pentru compararea modelelor, care echilibrează:


calitatea ajustării (cât de bine explică modelul datele)


complexitatea modelului (numărul de parametri)


Definiția formală


𝐴𝐼𝐶 = 2 𝑘      - 2 ln(𝐿)


unde:


𝑘 = numărul de parametri ai modelului
𝐿 = valoarea funcției de verosimilitate (likelihood)


AIC caută un echilibru între fit bun și model simplu.


**2.** **Backward Elimination** : Se pornește de la modelul complet (cu toți predictorii disponibili)

și se elimină treptat variabilele nesemnificative statistic (de regulă, p > 0.05).


**3.** **Stepwise** : Reprezintă o abordare hibridă care combină cele două metode: la fiecare pas

se pot atât adăuga, cât și elimina variabile, în funcție de contribuția lor la model.


**4.** **Implementare practică (Mathematica)** : Selecția poate fi automatizată prin funcții pre
c u m :


StepwiseSelection pentru selecție iterativă,


sau prin compararea modelelor utilizând criterii informaționale, precum AIC (Akaike Information Criterion), care echilibrează calitatea ajustării cu complexitatea modelului.


**Observație metodologică**


_C9 Regresia multipla.nb_ **13**


Toate aceste metode urmăresc același obiectiv:


identificarea unui model parsimonios, care explică adecvat datele fără a introduce complexitate inutilă (în spiritul principiului lui Occam).


**14** _C9 Regresia multipla.nb_

### **6. Diagnosticul Modelului: Dincolo de Cifre**


Un model bun nu trebuie doar să aibă _R_ [2] mare, ci să respecte ipotezele fundamentale.


  - **Reziduuri** : Reziduurile trebuie să fie distribuite aproximativ normal și să nu prezinte

structuri sistematice, având varianță constantă (homoscedasticitate). În plus, acestea ar
trebui să se comporte ca un „zgomot alb”, adică să aibă medie nulă, varianță constantă și
să fie necorelate.


  - **Puncte de influență** (Cook’s Distance): Există vreo observație care „trage” de tot planul
de regresie spre ea? Dacă D > 1, acea dată este suspectă. Identificarea „valorilor aberante” care distorsionează planul de regresie.












_C9 Regresia multipla.nb_ **15**


_O u t [_ _]_


_O u t [_  _] =_

|Indicator Statistic|Valoare|
|---|---|
|Număr total de înscrieri (n)|81|
|Număr variabile independente (k)|2|
|Grade de libertate reziduale (n - k - 1)|78|
|Eroarea medie a modelului (σ)|1.492|



**TABEL** **DATE** **(n=25)**


**Afișare** **grafică** **în** **3D**


Ne imaginăm că fiecare rând din tabel este un stâlp înfipt în pământ la o anumită înălțime
( _Y_ ). Regresia Multiplă este ca și cum am întinde o cuvertură (planul, pocrâvalo) peste toți
acești stâlpi. Foaia nu se va așeza perfect pe fiecare stâlp, dar va încerca să stea cât mai
aproape de toți, în medie.


_C9 Regresia multipla.nb_ **17**


**18** _C9 Regresia multipla.nb_

### **7. Un studiu de caz**


Folosim un set de date real:


setul de date Boston Housing reflectă condițiile pieței imobiliare din jurul anului 1978, iar
valorile estimate ale variabilei MEDV sunt exprimate în mii de dolari din acea perioadă. Prin
urmare, rezultatele modelului trebuie interpretate în context istoric și nu ca estimări ale
prețurilor actuale, care sunt semnificativ mai mari datorită inflației și evoluției pieței
imobiliare.


În baza acestor date construim un model complet, parcurgând următoarele etape:


**1.** Inspecția corelațiilor.


**2.** Construcția modelului.


**3.** Curățarea modelului de variabile nesemnificative.


**4.** Predicția valorii unei noi locuințe.


**Calculul factorilor de inflație a varianței**


Codul de mai jos realizează calculul factorilor de inflație a varianței (Variance Inflation
Factor – VIF) pentru predictorii din dataset-ul „Boston Homes” disponibil în Wolfram Data
Repository.


Scopul principal este evaluarea gradului de multicoliniaritate între variabilele explicative
dintr-un model de regresie multiplă. În acest sens, scriptul parcurge următoarele etape:


**1.** Încărcarea datelor și extragerea predictorilor (excluzând variabila răspuns MEDV).


**2.** Transformarea datelor într-o formă numerică coerentă, prin:
    - conversia cantităților (Quantity) la valori numerice,
    - codificarea variabilelor categorice,
    - gestionarea valorilor lipsă.


**3.** Construirea matricei predictorilor și filtrarea observațiilor valide numeric.


**4.** Calculul matricei de corelație și determinarea VIF pe baza inversei acesteia.


**5.** Interpretarea valorilor VIF conform pragurilor standard:
    - VIF = 1 → fără coliniaritate,
    - 1–5 → coliniaritate moderată,
    - 5–10 → coliniaritate problematică,
    - >10 → coliniaritate severă.


_C9 Regresia multipla.nb_ **19**


**6.** Afișarea rezultatelor într-un tabel structurat, cu etichete matematice și interpretare

automată.


**Tabelul**


Prin codul ce urmează infra, se evidențiază impactul dependențelor dintre predictori asupra
stabilității estimărilor OLS, constituind un instrument esențial în analiza și validarea modelelor de regresie.


_O u t [_  _] =_

|Variabilă|Predictor|VIF|Interpretare|
|---|---|---|---|
|X1|CRIM|1.79|moderată|
|X2|ZN|2.30|moderată|
|X3|INDUS|3.99|moderată|
|X4|CHAS|1.07|moderată|
|X5|NOX|4.39|moderată|
|X6|RM|1.93|moderată|
|X7|AGE|3.10|moderată|
|X8|DIS|3.96|moderată|
|X9|RAD|7.48|problematică|
|X10|TAX|9.01|problematică|
|X11|PTRATIO|1.80|moderată|
|X12|BLACK|1.35|moderată|
|X13|LSTAT|2.94|moderată|



**Concluzia analizei VIF:**


Tabelul obținut evidențiază gradul de multicoliniaritate dintre predictorii modelului. Se
observă că variabilele cu valori VIF apropiate de 1 sunt practic independente de ceilalți
predictori, contribuind stabil și interpretabil la model.


Predictorii cu valori VIF în intervalul 1–5 indică o coliniaritate moderată, acceptabilă în
majoritatea aplicațiilor, fără a afecta semnificativ estimările coeficienților.


În schimb, variabilele pentru care VIF depășește pragul 5 (și în special 10) semnalează
prezența unei multicoliniarități problematice sau severe. În aceste cazuri, predictorii respectivi sunt puternic corelați cu alți predictori, ceea ce conduce la:


**20** _C9 Regresia multipla.nb_


   - creșterea varianței estimărilor coeficienților OLS,

   - instabilitatea numerică a modelului,

   - dificultăți în interpretarea efectelor individuale ale variabilelor.


Prin urmare, pentru un model robust, se recomandă:

   - investigarea predictorilor cu VIF ridicat,

   - eliminarea sau combinarea variabilelor redundante,

   - sau aplicarea unor metode alternative (regularizare, reducere dimensională).


În concluzie, analiza VIF oferă un diagnostic esențial pentru validarea modelului de regresie multiplă, evidențiind în ce măsură ipoteza de independență a predictorilor este încălcată
și cum afectează aceasta stabilitatea și interpretabilitatea modelului.


Modelul de regresie nu prezintă multicoliniaritate severă, ceea ce indică o stabilitate numerică adecvată a estimărilor OLS.


Totuși, variabilele RAD și TAX prezintă coliniaritate problematică, sugerând existența unei
dependențe semnificative între acești predictori. Această situație poate afecta interpretarea
coeficienților individuali, deși nu compromite în mod critic validitatea globală a modelului.


În ansamblu, modelul este utilizabil, dar necesită atenție în interpretarea predictorilor puternic corelați.


Așadar, modelul este stabil, dar nu perfect curat — avem o coliniaritate locală între RAD și
TAX.


**Construirea modelului de regresie liniară multiplă**


Acest script construiește un model de regresie liniară multiplă prin metoda celor mai mici
pătrate ordinare (OLS – Ordinary Least Squares), utilizând dataset-ul „Boston Homes” din
Wolfram Data Repository.


Scopul principal al codului este pregătirea corectă a datelor pentru estimarea modelului de
regresie și ajustarea modelului OLS într-o formă robustă din punct de vedere numeric. În
acest sens, scriptul parcurge următoarele etape:


**1.** Încărcarea dataset-ului și separarea variabilelor explicative de variabila răspuns. În acest

exemplu, variabila răspuns este MEDV, iar toate celelalte coloane sunt tratate ca
predictori.


**2.** Normalizarea valorilor din dataset, astfel încât informațiile să poată fi utilizate coerent în

calculele numerice. Sunt tratate explicit:
    - valorile deja numerice,
    - cantitățile cu unități (Quantity),
    - valorile logice True/False,
     - valorile lipsă,
     - și valorile textuale.


_C9 Regresia multipla.nb_ **21**


**3.** Codificarea numerică a fiecărei coloane. Dacă o coloană este deja numerică, ea este

păstrată ca atare; dacă este categorială, nivelurile sale sunt transformate în coduri
numerice pentru a putea fi incluse în model.


**4.** Construirea matricei predictorilor X și a vectorului răspuns y, urmată de eliminarea obser
vațiilor care nu sunt complet numerice, pentru a evita erorile de evaluare și problemele de
estimare.


**5.** Formarea structurii de date necesare regresiei și definirea variabilelor simbolice asociate

predictorilor, deoarece funcția LinearModelFit operează cu variabile simbolice și nu cu
denumiri textuale.


**6.** Estimarea modelului de regresie multiplă OLS, care permite:
    - determinarea coeficienților modelului,
    - evaluarea semnificației predictorilor,
     - analiza calității ajustării,
    - și interpretarea relației dintre predictorii selectați și variabila răspuns.


Prin urmare, acest cod oferă un cadru complet pentru trecerea de la un dataset eterogen la
un model de regresie multiplă valid și interpretabil, fiind util atât pentru analiză statistică
aplicată, cât și pentru demonstrații didactice.


In[1]:=


**ClearAll[ds,** **rows,** **predictors,** **responseName,** **normalizeCell,** **encodeColumn,**
**numericColumns,** **Xraw,** **yraw,** **goodRows,** **X,** **y,** **regData,** **vars,** **model];**


**(*1.** **Încărcarea** **datelor*)**
**ds = ResourceData["Sample** **Data:** **Boston** **Homes"];**
**ds〚1 ;; 5〛**
**rows = Normal[ds];**


**(*2.** **Predictori** **și** **răspuns*)**
**predictors = DeleteCases[Keys[First[rows]],** **"MEDV"];**
**responseName = "MEDV";**


**(*3.** **Normalizare** **generică*)**
**normalizeCell[x_] := Which[NumericQ[x],** **N[x],** **Head[x] === Quantity,**
**N[QuantityMagnitude[x]],** **TrueQ[x === True],** **1.,** **TrueQ[x === False],** **0.,**
**MissingQ[x] || x === Null,** **Missing["NA"],** **StringQ[x],** **StringTrim[x],** **True,** **x];**


**(*4.** **Codificare** **numerică** **pentru** **fiecare** **coloană*)**
**encodeColumn[col_List] := Module[{c,** **nonmissing,** **levels,** **map},** **c = normalizeCell /@ col;**
**nonmissing = DeleteMissing[c];**
**If[VectorQ[nonmissing,** **NumericQ],**
**N[c /.** **Missing["NA"] ** **Indeterminate],** **levels = DeleteDuplicates[nonmissing];**
**map = AssociationThread[levels ** **N[Range[0,** **Length[levels] - 1]]];**
**Replace[c,**
**{Missing["NA"] ** **Indeterminate,** **v_ /; KeyExistsQ[map,** **v] ** **map[v]},** **{1}]]];**


**22** _C9 Regresia multipla.nb_


**(*5.** **Construirea** **lui** **X** **și** **y*)**
**numericColumns = encodeColumn /@ (Lookup[rows,** **#] & /@ predictors);**
**Xraw = Transpose[numericColumns];**
**yraw = encodeColumn[Lookup[rows,** **responseName]];**


**(*6.** **Păstrăm** **doar** **rândurile** **complet** **numerice*)**
**goodRows =**
**Select[Range[Length[Xraw]],** **VectorQ[Xraw〚#〛,** **NumericQ] && NumericQ[yraw〚#〛] &];**


**X = Xraw〚goodRows〛;**
**y = yraw〚goodRows〛;**


**(*7.** **Date** **pentru** **regresie*)**
**regData = MapThread[Append,** **{X,** **y}];**


**(*8.** **Variabile** **simbolice,nu** **stringuri*)**
**vars = Array[x,** **Length[predictors]];**


**(*9.** **Model** **OLS*)**
**model = LinearModelFit[regData,** **vars,** **vars];**


Out[3]=

|CRIM|ZN|INDUS|CHAS|
|---|---|---|---|
|0.00632|18|2.31|tract does not bound Charles river|
|0.02731|0|7.07|tract does not bound Charles river|
|0.02729|0|7.07|tract does not bound Charles river|
|0.03237|0|2.18|tract does not bound Charles river|
|0.06905|0|2.18|tract does not bound Charles river|
|columns 1–10 of** 14**|columns 1–10 of** 14**|columns 1–10 of** 14**|columns 1–10 of** 14**|



Secțiunea următoare extrage și prezintă principalele rezultate ale modelului de regresie
liniară multiplă estimat prin metoda OLS. Sunt analizate atât forma explicită a modelului
(ecuația de regresie), cât și parametrii estimați, semnificația statistică a acestora și calitatea
globală a ajustării.


În mod concret:

   - model[“BestFit”] oferă ecuația estimată a regresiei;

   - model[“BestFitParameters”] furnizează valorile coeficienților;

   - model[“ParameterTable”] permite evaluarea semnificației statistice a fiecărui predictor;

   - model[“RSquared”] și model[“AdjustedRSquared”] măsoară capacitatea modelului


_C9 Regresia multipla.nb_ **23**


de a explica variabilitatea datelor;

   - model[“ANOVATable”] oferă o analiză globală a semnificației modelului.


Acești indicatori permit evaluarea completă a performanței modelului și fundamentează
interpretarea relației dintre variabilele explicative și variabila răspuns.

















În regresia liniară multiplă, coeficientul de determinare 𝑅 [2] are aceeași formă conceptuală
ca în regresia simplă, dar se aplică la modelul cu mai mulți predictori.







unde:

𝑦𝑖 = valorile observate
𝑦 [] _i_ = valorile estimate de model
𝑦 = media lui 𝑦


**24** _C9 Regresia multipla.nb_


Forma matriceală, importantă în regresia multiplă:











_R_ [2] ajustat:



_R_ [2] = 1 

unde:



 _y_ - _R_ [2] ( _n_ -1)

_n_  - _p_  - 1



𝑛 = numărul observațiilor
𝑝 = numărul predictorilor


_R_ [2] măsoară cât din variația variabilei răspuns este explicată de ansamblul predictorilor din
modelul de regresie multiplă.
















_C9 Regresia multipla.nb_ **25**


**Coeficienții estimați ai modelului de regresie multiplă**


Secțiunea următoare are rolul de a extrage și de a prezenta într-o formă structurată coeficienții estimați ai modelului de regresie multiplă.


Mai întâi sunt obținuți coeficienții modelului (inclusiv interceptul) prin model[“BestFitParameters”]. Ulterior, aceștia sunt organizați într-un tabel (Grid), în care fiecare coeficient este
asociat explicit cu predictorul corespunzător.


Interceptul este tratat separat, deoarece reprezintă valoarea estimată a variabilei răspuns
atunci când toți predictorii sunt egali cu zero, iar coeficienții predictorilor indică variația
medie a variabilei răspuns determinată de o unitate de creștere a fiecărui predictor, ceteris
paribus.


Tabelul rezultat oferă o prezentare clară și lizibilă a parametrilor modelului, facilitând interpretarea efectelor individuale ale predictorilor în cadrul regresiei multiple.


_O u t [_  _] =_


**Predicția valorii unei noi locuințe**

|Termen|Coeficient|
|---|---|
|Intercept|36.4595|
|CRIM|-0.1080|
|ZN|0.0464|
|INDUS|0.0206|
|CHAS|2.6867|
|NOX|-17.7666|
|RM|3.8099|
|AGE|0.0007|
|DIS|-1.4756|
|RAD|0.3060|
|TAX|-0.0123|
|PTRATIO|-0.9527|
|BLACK|0.0093|
|LSTAT|-0.5248|



După estimarea coeficienților modelului de regresie multiplă, următoarea etapă constă în
utilizarea modelului pentru predicția valorii unei noi locuințe.


În acest scop, se consideră un nou set de valori pentru predictorii modelului, corespunzător
unei observații noi. Aceste valori sunt introduse în ecuația regresiei estimate, iar modelul
calculează valoarea prezisă a variabilei răspuns MEDV.


Astfel, predicția reprezintă aplicarea practică a modelului de regresie: pe baza relațiilor
estimate între predictori și variabila răspuns, se obține o estimare a valorii unei locuințe noi,
caracterizate printr-un profil dat al variabilelor explicative.


**26** _C9 Regresia multipla.nb_











Descifrare în limbaj natural a predictorilor


1. 🏙️ CRIM = 0.10   👉 Rata criminalității per capita este foarte mică → zonă sigură


2. 🌳 ZN = 20.0     👉 20% din teren este zonat pentru loturi mari (>25,000 sq.ft.) → zonă rezidențială aerisită


3. 🏭 INDUS = 5.00  👉 5% din zonă este industrială → nivel redus de industrie (zonă relativ curată)


4. 🌊 CHAS = 0      👉 NU este lângă râul Charles → fără avantaj de proximitate la apă


5. 🌫️ NOX = 0.45    👉 Concentrație moderată de poluare (oxizi de azot) → aer relativ bun


6. 🏠 RM = 6.50      👉 Număr mediu de camere = 6.5 → locuință spațioasă


7. 🏚️ AGE = 45.0     👉 45% din locuințe sunt construite înainte de 1940 → zonă mixtă (nici foarte
veche, nici foarte nouă)


8. 🚗 DIS = 4.50      👉 Distanță moderată față de centrele de muncă → acces rezonabil la joburi


_C9 Regresia multipla.nb_ **27**


9. 🛣️ RAD = 4        👉 Acces moderat la autostrăzi radiale → infrastructură decentă


10. 💰 TAX = 300     👉 Taxa pe proprietate = 300 (relativ moderată) → costuri fiscale acceptabile


11. 🎓 PTRATIO = 15.0 👉 Raport elev-profesor = 15 → școli relativ bune


12. 📈 BLACK = 390   👉 Indicator socio-economic (aproape de maxim = 400) → zonă stabilă socioeconomic (în sensul dataset-ului original)


13. 📉 LSTAT = 8.0    👉 8% populație cu statut socio-economic scăzut → zonă relativ bună (nu
defavorizată)


**28** _C9 Regresia multipla.nb_

### **8. Rezultate de învățare**


🎓 **La final, stăpânim:**


  - Construcția modelelor multivariate.


  - Distincția între corelație și cauzalitate controlată.


  - Depanarea modelelor prin VIF și analiza reziduurilor.


_C9 Regresia multipla.nb_ **29**

### **Setări**

## ◼ Setări notebook ◼ Setări celule


