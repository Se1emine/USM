# **Logistic Regression**

_**Presenter**_


**Valeriu Ungureanu**


_**Data**_


_**Wednesday, 1 April 2026**_


_**Moldova State University**_


_Statistical Methods for Data Analysis_


**2** _C10 Regresia logistica.nb_

#### **1. Inițiere în Regresia Logistică**

## **Scopul lecției**


**Regresia logistică** este un algoritm esențial în învățarea automată, utilizat pentru **clasifi-**
**carea rezultatelor categorice** . În continuare vom oferi o introducere clară în principiile și
aplicațiile regresiei logistice, evidențiind modul în care putem modela și prezice valori
binare sau multinomiale pe baza unor variabile independente.


Vom pune accentele pe:


 **Bazele** **teoretice** : Cum funcționează regresia logistică, inclusiv conceptul de funcție

logistică și interpretarea probabilităților.


 **Aplicarea practică** : Cum să se implementeze regresia logistică folosind date reale, să se

evalueze performanța modelului (de exemplu, prin acuratețe, precizie, recall) și să se
interpreteze rezultatele.


 **Diferența față de regresia liniară** : De ce regresia logistică este potrivită pentru clasifi
care și nu pentru predicția valorilor continue.


 **Exemple concrete** : Cum să se aplice regresia logistică în scenarii precum diagnosti
carea medicală (ex. bolnav/sănătos), detectarea spamului (spam/non-spam) sau predicția
succesului (da/nu).

## **Competențe dobândite**


 **Înțelegerea modelului** : Vom înțelege cum regresia logistică transformă o combinație

liniară a variabilelor de intrare într-o probabilitate între 0 și 1.


 **Fundamentare matematică** : Vom studia funcția logistică (sigmoida), optimizarea prin

maximizarea funcției likelihood și interpretarea coeficienților modelului.


 **Abilități practice** : Vom putea construi, antrena și testa un model de regresie logistică

folosind instrumente precum Python (ex. scikit-learn).


 **Gândire analitică** : Vom învăța să analizăm rezultatele și să ajustezăm modelul pentru a

îmbunătăți predicțiile.

## **Importanța regresiei logistice**


Regresia logistică este esențială din mai multe motive:


_C10 Regresia logistica.nb_ **3**


**Simplitate și eficiență** : Este un model statistic fundamental, a cărui estimare se realizează prin algoritmi de optimizare relativ simpli, dar eficienți, și care constituie un punct
de referință pentru înțelegerea unor metode de clasificare mai complexe, precum rețelele
neuronale.


**Interpretare ușoară** : Coeficienții modelului oferă informații clare despre influența fiecărei
variabile asupra rezultatului, ceea ce o face valoroasă în domenii precum medicina sau
științele sociale.


**Bază pentru alte metode** : Mulți  algoritmi avansați (ex. SVM, rețelele neuronale) se
bazează pe principii similare celor din regresia logistică.


**Aplicabilitate largă** : Este utilizată în variate industrii – de la marketing (predicția comportamentului clienților) la finanțe (evaluarea riscului de credit) și tehnologie (clasificarea
textului).


**Robustețe** : Funcționează bine cu seturi de date mici sau medii și este mai puțin predispusă la supra-învățare (overfitting) decât modelele mai complexe, atunci când este aplicată corect.


Pe scurt, _regresia logistică este importantă pentru că oferă o punte între statistică_ _și_
_învățarea automată_, fiind un instrument accesibil, interpretabil și eficient pentru rezolvarea
problemelor de clasificare.

## **Motivația practică**


Prezentăm doar câteva exemple practice concrete în care regresia logistică e utilizată pe
scară largă. Exemplele ilustrează versatilitatea algoritmului în rezolvarea problemelor reale
de clasificare:


**1.** **Diagnostic medical**


  - **Exemplu** : Predicția dacă un pacient are sau nu o anumită boală (ex. cancer, diabet) pe

baza unor variabile precum vârsta, analize de sânge, istoricul medical etc.


  - **Cum funcționează** : Regresia logistică analizează datele pacientului și estimează probabil
itatea ca acesta să fie bolnav (ex. 0 = sănătos, 1 = bolnav). De exemplu, un medic poate
folosi modelul pentru a decide dacă este necesară o biopsie bazându-se pe rezultatele
unui test preliminar.


  - **De ce e utilă** : Este interpretabilă – medicii pot vedea care factori (ex. nivel ridicat de

glucoză) contribuie cel mai mult la predicție.


**2.** **Analiza riscului de credit**


  - **Exemplu** : Determinarea dacă un solicitant de împrumut va intra sau nu în incapacitate de

plată (default) pe baza istoricului financiar, venitului, datoriilor existente etc.


**4** _C10 Regresia logistica.nb_


  - **Cum funcționează** : Modelul calculează probabilitatea ca un client să nu-și plătească

datoria (0 = plătește, 1 = nu plătește). Băncile folosesc acest scor pentru a aproba sau
respinge cererile de credit.


  - **De ce e utilă** : Ajută instituțiile financiare să minimizeze riscurile și să ia decizii obiective

bazate pe date.


**3.** **Detectarea spam-ului**


  - **Exemplu** : Clasificarea e-mailurilor ca spam sau non-spam pe baza conținutului (cuvinte
cheie, expeditor, lungimea mesajului etc.).


  - **Cum funcționează** : Regresia logistică analizează caracteristicile unui e-mail și prezice

probabilitatea ca acesta să fie spam (0 = legitim, 1 = spam). De exemplu, prezența cuvintelor precum „câștigă acum” ar putea crește probabilitatea de spam.


  - **De ce e utilă** : Este rapidă și eficientă pentru filtrarea automată a mesajelor, îmbunătățind
experiența utilizatorilor.


**4.** **Marketing (predicția comportamentului clienților)**


  - **Exemplu** : Estimarea probabilității ca un client să cumpere un produs pe baza datelor

precum istoricul de achiziții, activitatea pe site sau demografice (vârstă, locație).


  - **Cum funcționează** : Modelul atribuie o probabilitate fiecărui client (0 = nu cumpără, 1 =

cumpără), ajutând companiile să țintească mai bine campaniile publicitare.


  - **De ce e utilă** : Optimizează bugetele de marketing și crește rata de conversie.


**5.** **Analiza sentimentelor**


  - **Exemplu** : Clasificarea recenziilor online ca pozitive sau negative pe baza textului scris de

utilizatori.


  - **Cum funcționează** : Regresia logistică analizează cuvintele sau frazele din recenzie și

prezice sentimentul (0 = negativ, 1 = pozitiv). De exemplu, „excelent” ar crește probabilitatea unui sentiment pozitiv.


  - **De ce e utilă** : Companiile pot monitoriza rapid feedback-ul clienților și ajusta produsele

sau serviciile.


**6.** **Predicția abandonului (churn prediction)**


**Exemplu** : Determinarea probabilității ca un abonat (ex. la un serviciu de telefonie sau
streaming) să renunțe la abonament.


**Cum** **funcționează** : Folosind date precum frecvența utilizării, plângeri anterioare sau
durata abonamentului, modelul estimează șansele de churn (0 = rămâne, 1 = pleacă).


**De ce e utilă** : Permite companiilor să identifice clienții „la risc” și să le ofere incentivi pentru
a-i păstra.


_C10 Regresia logistica.nb_ **5**


**7.** **Detectarea fraudei**


  - **Exemplu** : Identificarea tranzacțiilor bancare frauduloase pe baza tiparelor de cheltuieli,
locației sau orei.


  - **Cum funcționează** : Modelul analizează caracteristicile tranzacției și prezice dacă este

legitimă sau suspectă (0 = normală, 1 = fraudă).


  - **De ce e utilă** : Ajută la protejarea clienților și la reducerea pierderilor financiare.


_Exemplele_ _enumerate_ _demonstrează_ _că_ _regresia_ _logistică_ _este_ _un_ _instrument_ _versatil_
_(универсальный), aplicabil în diverse domenii, de la sănătate și finanțe la tehnologie și_
_marketing_ . Simplitatea sa, combinată cu capacitatea de a oferi rezultate interpretabile, o
face indispensabilă în analiza datelor și luarea deciziilor bazate pe predicții.


**8.** **De ce nu e suficientă regresia liniară?**


  - **Exemplu** : Pentru problema de clasificare bivalentă, regresia liniară nu oferă doar două

valori, ci o infinitate! Să ilustrăm acest lucru!













Definim funcția RSS(β):


**6** _C10 Regresia logistica.nb_









Să reprezentăm grafic această funcție:







Minimul acestei funcții poate fi determinat folosind posibilitățile limbajului Wolfram:






_C10 Regresia logistica.nb_ **7**











**Nota bene** . Regresia liniară nu este adecvată pentru rezolvarea corectă și robustă a unei
probleme de clasificare bivalentă (0/1, da/nu, pozitiv/negativ) din motive structurale, nu
doar din considerente practice.


**8** _C10 Regresia logistica.nb_

#### **2. Bazele teoretice ale Regresiei Logistice**

## **Ce este regresia logistică?**


Regresia logistică este un **model statistic parametrizat**, antrenat prin algoritmi de optimizare și utilizat ca **algoritm de clasificare a rezultatelor categorice** . _Să oferim o introduc-_
_ere clară în principiile și aplicațiile regresiei logistice, evidențiind modul în care putem mod-_
_ela și prezice valori binare sau multinomiale pe baza unor variabile independente_ .

## **Bazele teoretice**

### Ipoteza de bază


**Regresia logistică nu estimează direct un rezultat binar (0 sau 1), ci modelează logarit**
**mul raportului de șanse**   - adică


log _[p]_
1- _p_ [= β][₀][ + β][₁][ x][₁][ + β][₂][ x][₂][ +][ ...][ + β][ₙ][ x][ₙ][,]


cunoscut sub numele de log-odds. Acest logaritm exprimă tendința unui eveniment de a
aparține clasei pozitive (de exemplu, clasa 1), în raport cu probabilitatea de a nu aparține
acesteia.


Rezolvând ecuația în raport cu p, obținem:

















adică:


unde _z_ = β₀ + β₁ x₁ + β₂ x₂ + ... + βₙ xₙ.



_p_ = 1
1 +  [-] _[z]_ [,]



Această funcție, denumită funcție **logistică** sau **sigmoidă**, aparține familiei funcțiilor ale
căror grafice au formă de **S** și asigură că probabilitatea estimată se încadrează întotdeauna
în intervalul (0, 1), oferind astfel o interpretare coerentă în contextul clasificării binare.


_C10 Regresia logistica.nb_ **9**

### Funcția logistică/sigmoidă


Funcția logistică (sigmoidă) este nucleul  regresiei logistice. Ea transformă o combinație
liniară de variabile de intrare într-o valoare între 0 și 1, care poate fi interpretată ca o probabilitate. Matematic, funcția sigmoidă este definită astfel:

### Odds, log-odds și interpretarea coeficienților

#### **Ce este odds (șansele)?**


Odds (șanse, шансы) reprezintă raportul dintre probabilitatea ca un eveniment să se întâmple și probabilitatea ca acel eveniment să nu se întâmple. Este o măsură a „ _cât de favora-_
_bil_ ” (благоприятным) este un rezultat față de opusul său. Matematic, odds-ul se definește
astfel:


_p_
odds =
1 - _p_


unde:


  - _p_ este probabilitatea ca evenimentul să aibă loc (ex. _p_ ( _y_ = 1)),


  - 1 − _p_ este probabilitatea ca evenimentul să nu aibă loc (ex. _p_ ( _y_ = 0)).


**Exemplu** :


Dacă probabilitatea ca un student să treacă un examen este _p_ = 0.75 (75%), atunci:











Aceasta înseamnă că șansele sunt 3 la 1 în favoarea trecerii examenului (de 3 ori mai
probabil să treacă decât să pice).


Interpretare:


- Odds > 1: Evenimentul este mai probabil să se întâmple decât să nu se întâmple.


- Odds = 1: Evenimentul și opusul său sunt la fel de probabile ( _p_ = 0.5).


- Odds < 1: Evenimentul este mai puțin probabil să se întâmple.


**10** _C10 Regresia logistica.nb_










#### **Ce este log-odds?**






|2<br>0<br>8<br>6<br>4<br>2|0.2 0.4 0.6 0.8 1.0|
|---|---|
|||



Log-odds-ul este logaritmul raportului dintre probabilitatea clasei pozitive și cea a clasei
negative:


De fapt, aceasta este funcția logit, adică:


_p_
logit( _p_ ) = ln
1 - _p_ [= β][₀][ + β][₁][ x][₁][ + β][₂][ x][₂][ +][ ...][ + β][ₙ][ x][ₙ]


Coeficienții β _i_ indică influența fiecărei variabile _xi_ asupra log-odds-ului. Un β _i_ pozitiv
înseamnă că o creștere a lui _xi_ crește probabilitatea clasei pozitive, iar un β _i_ negativ o
scade.


Este important să se înțeleagă clar deosebirea dintre odds și log-odds, doi termeni esențiali
în regresia logistică.

#### **Revenim la ce este log-odds?**


Log-odds este logaritmul natural al odds-ului. Prin aplicarea logaritmului, se transformă
raportul de șanse într-o scară continuă care poate varia de la −∞ la +∞. Matematic, logodds-ul este:


_p_
log_odds = ln 
1 - _p_ []


**Exemplu** :


Folosind același caz, cu _p_ = 0.75: odds = 3


_C10 Regresia logistica.nb_ **11**





Set: Tag Real in log : Blank[3.] is Protected.







Interpretare:


- Log-odds > 0: Probabilitatea este mai mare de 50% (odds > 1).


- Log-odds = 0: Probabilitatea este exact 50% (odds = 1).


- Log-odds < 0: Probabilitatea este mai mică de 50% (odds < 1).











|Col1|0.2 0.4 0.6 0.8 1.0|
|---|---|
|||

#### **Deosebirea principală**

**Scara valorilor**








- **Odds** : Este un raport pozitiv (între 0 și +∞), dar nu este liniar și poate crește exponențial

pe măsură ce _p_ se apropie de 1.


- **Log-odds** : Transformă odds-ul într-o scară simetrică și continuă (de la −∞ la +∞), ceea

ce îl face mai ușor de modelat liniar.


**Relația cu probabilitatea**


- **Odds** : Este o reprezentare directă a raportului dintre succes și eșec, dar nu este limitat

între 0 și 1 ca probabilitatea.


**12** _C10 Regresia logistica.nb_


  - **Log-odds** : Este o transformare a odds-ului care permite utilizarea unei combinații liniare

(ca în regresia liniară) pentru a modela probabilitățile indirect.


**Utilizare în regresia logistică**


  - Regresia logistică modelează log-odds-ul ca o funcție liniară a variabilelor de intrare:


log_odds = β₀ + β₁ x₁ + β₂ x₂ + ... + βₙ xₙ


  - Apoi, prin funcția sigmoidă, log-odds-ul este transformat înapoi în probabilitate:


_p_ = 1
1 +  [-][ log][_][odds]


  - Odds-ul, deși important conceptual, nu este folosit direct în ecuația modelului, ci servește

ca pas intermediar.













|p|odds= p<br>1-p|log(odds)|
|---|---|---|
|0|0|-∞|
|0.1|0.111111|-2.19722|
|0.25|0.333333|-1.09861|
|0.5|1.|0.|
|0.75|3.|1.09861|
|0.9|9.|2.19722|
|0.9999|9999.|9.21024|


**De ce contează această deosebire?**


- **Odds** : Este intuitiv pentru interpretarea șanselor relative (ex. „de 3 ori mai probabil”), dar

nu este potrivit pentru modelare liniară, deoarece crește neliniar și nu este simetric.


- **Log-odds** : _Permite regresiei logistice să folosească o abordare liniară_ (similară regresiei

liniare) _pentru a estima probabilitățile_, ceea ce simplifică calculul și optimizarea modelului.


- **Pe scurt**, _odds descrie raportul brut al probabilităților, iar log-odds îl transformă într-o_

_formă matematică mai flexibilă: liniară, esențială pentru construcția regresiei logistice_ .


_C10 Regresia logistica.nb_ **13**


**14** _C10 Regresia logistica.nb_

#### **3. Modelul Regresiei Logistice**

## **Modelul matematic**


**Modelul** regresiei logistice este o **formulă** (metodă) matematică utilizată pentru a **prezice**
**probabilitatea** ca o observație să aparțină unei anumite clase (de obicei binare, ex. 0 sau
1) pe baza unuia sau mai multor predictori (variabile independente).


Regresia logistică combină o abordare liniară ( **combinația liniară** )pentru a modela relația
dintre variabilele de intrare și o transformare neliniară ( **funcția sigmoidă** ) pentru a transforma combinația liniră în probabilitate.


Matematic, modelul regresiei logistice poate fi exprimat astfel:


unde:


  - p( y = 1 ∣ x) este probabilitatea ca rezultatul y să fie 1 (clasa pozitivă) dat fiind setul date

de intrare x, corespunzător variabilelor de intrare _x_ 1, _x_ 2, ..., _xn_,

  - _x_ = ( _x_ 1, _x_ 2, ..., _xn_ ) _[T]_   - variabilele independente (de intrare, predictorii),


◇β0 - interceptul (termenul constant),


◇β1, β2, ..., β _n_   - coeficienții asociați fiecărei variabile _xi_,


◇ - baza logaritmului natural (constanta lui Euler).


Această expresie este cunoscută ca **funcția logistică sau sigmoidă**, iar termenul


β₀ + β₁ x₁ + β₂ x₂ + ... + βₙ xₙ


este denumit combinația liniară sau z.

## **Etapele modelării**

### **Combinația liniară (z)**


Modelarea începe prin **calcularea unei combinații liniare a variabilelor de intrare pon-**
**derate cu coeficienții lor** :


_z_ = β₀ + β₁ x₁ + β₂ x₂ + ... + βₙ xₙ


Aceasta reprezintă „scorul-estimarea” liniară a observației, similar regresiei liniare.


_C10 Regresia logistica.nb_ **15**

### **Transformarea în log-odds**


**Valoarea z este echivalentă cu log-odds-ul** (logaritmul raportului de șanse):

### **Transformarea în probabilitate**


**Log-odds-ul este apoi transformat în probabilitate folosind funcția sigmoidă** :


Aceasta asigură că rezultatul este o valoare între 0 și 1, interpretabilă ca probabilitate.

### **Clasificarea**


**Pentru a face o predicție binară, se stabilește un prag** (de obicei 0.5):


  - Dacă p(y = 1 ∣ x) ≥ 0.5, se prezice y = 1.


  - Dacă p(y = 1 ∣ x) < 0.5, se prezice y = 0.


_Pragul poate fi ajustat în funcție de obiectivele specifice_ (ex. pentru a favoriza precizia
uneia dintre clase).

## **Antrenarea modelului** **Exemplu simplu**


Să presupunem că vrem să prezicem dacă un student va trece un examen (y = 1) pe baza
orelor de studiu (x). Modelul ar putea fi:













Dacă x = 7 ore de studiu, atunci z = -2 + 0.5 × 7 = 1.5,






**16** _C10 Regresia logistica.nb_


iar _p_ = 1+1 [-][1.5] [≈] [0.817574,]









Așadar, dacă pragul este 0.5, modelul prezice valoarea y = 1, ceea ce înseamnă că studentul va susține examenul.

## **Caracteristicile modelului**


- **Ipoteza liniară** : Presupune că log-odds-ul este o combinație liniară a variabilelor de

intrare.


- **Ieșire probabilistică** : Produce probabilități, nu valori continue sau categorii directe.


- **Flexibilitate** : Poate fi extins la clasificare multinomială (mai multe clase) sau ordinală.

## **Echivalența reprezentărilor alternative**


Să remarcăm că modelul poate fi reprezentat în _**două forme alternative, echivalente**_ :


Ultima formă subliniază legătura cu regresia liniară, dar cu o transformare logistică aplicată
rezultatului.


Pe scurt, _modelul regresiei logistice_ :


 **combină liniar variabilele de intrare**,


 **transformă rezultatul în log-odds**


 și apoi **log-odds e transformat în probabilități prin funcția sigmoidă**,


_oferind un cadru robust (надёжную основу) pentru clasificare binară_ . Este simplu, interpretabil și eficient, ceea ce îl face un pilon al învățării automate.


_C10 Regresia logistica.nb_ **17**

## **Interpretarea grafică**
























|P = 0.955|Col2|Col3|
|---|---|---|
||||
||||
||||
|**_x_0**<br>**_x_* = -0.22**|**_x_0**<br>**_x_* = -0.22**|**_x_0**<br>**_x_* = -0.22**|




**18** _C10 Regresia logistica.nb_

#### **4. Estimarea Parametrilor**

## **Ce înseamnă „likelihood”?**


Metoda de maximizare a verosimilității ( **M** aximum **L** ikelihood **E** stimation, MLE,
максимизация правдоподобия) este o tehnică statistică fundamentală utilizată în regresia
logistică pentru a estima parametrii modelului (β0, β1, ..., β _n_ ). Scopul este de a găsi acele
valori ale coeficienților care fac ca datele observate să fie cele mai „probabile” în modelul
propus.


**Likelihood** (verosimilitatea, probabilitatea condiționată, правдоподобие, условная
вероятность) _reprezintă probabilitatea de a observa datele reale_ ( _y_ 1, _y_ 2, ..., _ym_ ) _dat fiind un_
_anumit set de parametri_ (β) _și variabile de intrare_ _xi_ = ( _x_ i1, _x_ i2, ..., _x_ in) _[T]_ .


În regresia logistică, vrem să **maximizăm** această probabilitate, adică să găsim
β = (β0, β1, ..., β _n_ ) _[T]_ care fac ca predicțiile modelului să se potrivească cel mai bine cu observațiile reale.


Probabilitatea ca o observație _yi_ să fie 1 (clasa pozitivă) este dată de funcția sigmoidă:


iar probabilitatea ca o observație _yi_ să fie 0 este:









Aceste probabilități depind de parametrii β = (β0, β1, ..., β _n_ ) _[T]_ .

## **Funcția likelihood total**


Presupunem că observațiile sunt independente între ele. În aceasăt supoziție, likelihood-ul
total (L) este produsul probabilităților individuale pentru toate observațiile din setul de date:


_m_

_L_ (β) =  _p_ ( _yi_ _xi_, β)

_i_ =1


unde:


_p_ ( _yi_ _xi_, β) = _p_ ( _yi_ = 1 _xi_, β), dacă _yi_ = 1,


_p_ ( _yi_ _xi_, β) = _p_ ( _yi_ = 0 _xi_, β), dacă _yi_ = 0.


_C10 Regresia logistica.nb_ **19**


Formula spune: „ _Cât de probabil este să observăm întregul set de date, dacă parametrii_
_sunt_ 𝛽?”


Ea poate fi scrisă sub forma:





_L_ (β) = 



1- _yi_





_i_ =1





unde _zi_ = β0 + β1 _x_ i1 + β2 _x_ i2 + … + β _n x_ in. Această expresie selectează automat probabilitatea
corespunzătoare clasei reale:
𝑝𝑖 dacă 𝑦𝑖 = 1 și 1 - 𝑝𝑖 dacă 𝑦𝑖 = 0, permițând o formulare unificată a likelihood-ului (𝑦𝑖 se ia
din datele inițiale).

## **Funcția Log-likelihood**


**Deoarece produsul multor probabilități poate duce la numere foarte mici** (dificil de
lucrat numeric), **este mai convenabil să maximizăm logaritmul likelihood-ului** (loglikelihood, notat ℓ(β)). Logaritmul transformă produsul în sumă:



_m_

ℓ(β) = 

_i_ =1





_yi_ ln



+ (1 - _yi_ ) ln



Simplificând:



_m_

ℓ(β) = ( _yi_ ln ( _p_ ( _yi_ = 1 _xi_, β)) + (1 - _yi_ ) ln (1 - _p_ ( _yi_ = 1 _xi_, β)))



_i_ =1


**Anume această funcție log-likelyhood se maximizează** .

## **Maximizarea log-likelihood-ului**


Pentru a găsi cei mai buni parametri β, se cere a fi determinate valorile care maximizează
funcția ℓ(β). Acest lucru se face prin:

### **Calculul derivativelor parțiale**


Luăm derivata ℓ(β) față de fiecare parametru β _j_ și le egalăm cu zero:



∂ℓ(β)


∂β _j_



= 0, pentru _j_ = 0, 1, ..., _n_ .



Derivata pentru β _j_ este:



1

1 + _e_ [-] _[z][i]_ [,]



∂ℓ(β)



_m_
_x_ ij _yi_  


= 
∂β _j_



_i_ =1


**20** _C10 Regresia logistica.nb_


Aici, 1+1 _e_ [-] _[z][i]_ [ este predicția oferită de model, iar ] _[y][i]_ [ -] 1+1 _e_ [-] _[z][i]_ [reprezintă eroarea de predicție.]

### **Sistem neliniar**


Spre deosebire de regresia liniară, ecuațiile rezultate nu au o soluție analitică directă.


Sistemul este neliniar din cauza funcției sigmoide.

### **Metode numerice**


Pentru a rezolva acest sistem, se folosesc algoritmi iterativi, cum ar fi:


**Metoda gradientului** : Ajustează β  în direcția creşterii funcției ℓ(β) folosind derivatele
parțiale:



β _j_ = β _j_ + η



∂ℓ(β)


∂β _j_



unde η este rata de învățare.


**Newton-Raphson** : Folosește atât derivata întâi, cât și derivata a doua (Hessiana) pentru
a converge mai rapid.


**Metoda antigradientului** : Echivalent, se minimizează negativul log-likelihood-ului (logloss), care este funcția de pierdere standard în regresia logistică:


Loss = −ℓ(β)


_C10 Regresia logistica.nb_ **21**

#### **5. Regresia liniară vs cea logistică**


Regresia liniară este utilizată în cazul când valorile variabilei dependente sunt de tip **con-**
**tinuu** . În cazul când valorile sunt discrete, regresia liniară nu mai funcționează. În baza ei
se construiește regresia logistică.


Regresia **liniară** și cea **logistică** sunt două tipuri de modele statistice utilizate pentru a
analiza relațiile dintre variabile. Deși ambele sunt folosite în scopuri de predicție, ele diferă
în ceea ce privește tipurile de date pe care le modelează și metoda de calcul. Iată principalele diferențe:

## **Regresia liniară**


  - **Scop** : Se folosește pentru a modela relația dintre o variabilă dependentă (de răspuns)

continuă și una sau mai multe variabile independente (predictori).


  - **Model** : Relația dintre variabile este reprezentată printr-o linie dreaptă în cazul elementar

și printr-un hiperplan în caz general.


  - **Funcția** : _y_ = β₀ + β₁ x₁ + β₂ x₂ + ... + βₙ xₙ + ε


  - **Predicții** : Valoarea variabilei dependente este continuă și poate lua orice valoare reală.


  - **Aplicații** : Folosit pentru predicția vânzărilor, prețurilor, veniturilor etc.

## **Regresia logistică**


  - **Scop** : Se folosește pentru a modela relația dintre   - variabilă dependentă binară

(dichotomă) și una sau mai multe variabile independente.


  - **Model** : Relația dintre variabile este reprezentată printr-o curbă logistică (forma literei “S”).


În loc să modeleze direct probabilitatea, regresia logistică modelează logaritmul natural al
raportului dintre probabilitatea de succes și probabilitatea de eșec (log-odds), folosind
funcția logit:


_p_
logit( _p_ ) = ln
1 - _p_ [= β][₀][ + β][₁][ x][₁][ + β][₂][ x][₂][ +][ ...][ + β][ₙ][ x][ₙ]


sau funcția logistică:


_P_ ( _y_  1) = 1
1 +  [-(β][₀][+β][₁][ x][₁][+β][₂][ x][₂][+][...][+β][ₙ][ x][ₙ][)]


  - **Predicții** : Valoarea variabilei dependente este probabilitatea (între 0 și 1) ca evenimentul
de interes să aibă loc.


**22** _C10 Regresia logistica.nb_


  - **Aplicații** : Folosit pentru clasificarea și predicția evenimentelor binare, cum ar fi deter
minarea probabilității ca un client să cumpere un produs, diagnosticul unei boli
(prezență/absență) etc.


În concluzie, regresia liniară este potrivită pentru predicții pe baza unor valori continue, în
timp ce regresia logistică este adecvată pentru clasificarea și predicția evenimentelor
binare.

## **Funcții de activare**

**Funcția logistică** : f(x) = σ(x) = [] _[x]_ 1

1+ _[x]_ [ = ] 1 +  [-] _[x]_

σ [′] ( _x_ ) σ( _x_ ) (1 - σ( _x_ ))


numită și sigmoidă, este o funcție matematică utilizată în regresia logistică pentru a transforma valoarea unei variabile independente în probabilitate. Funcția sigmoidă are forma
literei S, similară cu o curbă logistică, și mapează valorile reale pe intervalul [0, 1].


Termenul „logistic” pentru această funcție **are rădăcini istorice** în aplicarea sa la modelele
de creștere. Funcția logistică a fost introdusă pentru prima dată de **Pierre François Ver-**
**hulst în secolul al XIX-lea** pentru a modela creșterea populației. El a numit-o _„curba logis-_
_tică_ ” deoarece descria o formă particulară de creștere care era continuă și mărginită.

### **Funcția logistică, legea normală și funcțiile de activare**


Deși vizual cele două curbe au forma caracteristică de „S” (sigmoidă), este important de
precizat că funcția logistică nu coincide matematic cu funcția de repartiție a legii normale
(numită și funcția probit).


Deși ambele sunt utilizate pentru a modela probabilități sau fenomene de saturație, există
diferențe fundamentale:


  - **Originea matematică** : Funcția de repartiție a legii normale este integrala densității de

repartiție a legii normale și nu are o formă analitică închisă (nu poate fi scrisă printr-o
formulă simplă, fără integrală). În schimb, funcția logistică are o formulă exponențială
simplă și directă: _f_ ( _x_ ) = 1
1 +  [-] _[x]_ [ .]


  - **Distribuția Logistică** : Funcția logistică este, într-adevăr, funcția de repartiție a unei legi

de probabilitate specifice, numită **Legea Logistică** . Aceasta este o lege distinctă de
Legea Normală; deși seamănă foarte mult cu ea, legea logistică are „cozi” mai grele
(valorile extreme sunt puțin mai probabile decât în cazul legii normale).


  - **Utilizare** : În statistică, utilizarea integralei legii normale duce la modelele de tip **Probit**, în

timp ce utilizarea funcției lui Verhulst duce la modelele de tip **Logit** (Regresia Logistică).


_C10 Regresia logistica.nb_ **23**


Funcția logistică captează un model de creștere mai realist comparativ cu funcțiile liniare,
luând în considerare creșterea rapidă inițială care încetinește treptat pe măsură ce se
apropie de un plafon maxim, reflectând limitările resurselor sau capacitatea de suport în
sistemele biologice.


Astfel, termenul „logistic” a rămas datorită utilizării sale istorice în modelele de creștere și
proprietăților sale matematice, deși este aplicabil la o gamă largă de fenomene dincolo de
creștere.


Funcțiile de activare definesc transformarea neliniară într-un neuron artificial:

_y_ = _f_ 𝑤 [𝑇] 𝑥 + 𝑏


Funcția logistică este și ea funcție de activare. Principalele particularități și diferențe ce țin
de ele sunt incluse în următorul tabel:


_O u t [_  _] =_

|Aspect Funcția Logistică (Sigmoidă)<br>Natură Funcție specifică<br>Rol principal Probabilitate + Activare<br>Utilizare Output (Binar)<br>Interval (Range) (0, 1)|Activări (ReLU, Tanh etc.)<br>Categorie de funcții<br>Introducere non-linearitate<br>Hidden layers (predominant)<br>Variabil: (0, ∞) sau (-1, 1)|
|---|---|
|_Derivabilitate_<br>Netedă, peste tot<br>_Zero_-_Centered_<br>Nu (Media > 0)<br>_Problemă_<br>Vanishing Gradient<br>_Cost Comp._<br>Ridicat (funcție exp.)|ReLU: nederivabilă în 0<br>Tanh: da / ReLU: nu<br>Saturație sau Dead ReLU<br>Scăzut (ex. ReLU liniar)|


### **Exemple de funcții de activare/logistice/sigmoide** **Exemple de aplicații ale sigmoidei în regresia logistică**


  - **Predicția** **probabilității** **ca** **un** **client** **să** **cumpere** **un** **produs** :


Variabila independentă ar putea fi venitul clientului, iar variabila dependentă ar fi o valoare binară (0 - nu a cumpărat, 1 - a cumpărat). Funcția sigmoidă transformă venitul
clientului într-o probabilitate ca acesta să cumpere produsul.


  - **Predicția** **probabilității** **ca** **un** **pacient** **să** **aibă** **o** **anumită** **boală** :


Variabila independentă ar putea fi un set de simptome ale pacientului, iar variabila dependentă ar fi o valoare binară (0 - nu are boala, 1 - are boala). Funcția sigmoidă ar transforma simptomele pacientului într-o probabilitate ca acesta să aibă boala.

### **Avantaje și dezavantaje**


**Avantaje** :


Sigmoida este o funcție non-liniară, permițând modelarea relațiilor complexe dintre variabile.


**24** _C10 Regresia logistica.nb_


Sigmoida este o funcție monotonă, asigurând o creștere sau o descreștere constantă a
probabilității.
Sigmoida este    - funcție diferențiabilă, permițând utilizarea algoritmilor de optimizare
pentru antrenarea modelului.


**Dezavantaje** :


Sigmoida poate fi sensibilă la valori aberante din setul de date.
Sigmoida poate fi dificil de interpretat în anumite contexte.

### **Concluzie**


_Sigmoida este o funcție fundamentală în regresia logistică, care permite maparea combi-_
_nației liniare a variabilelor independente într-o distribuție de probabilitate, facilitând inter-_
_pretarea rezultatelor în termeni probabilistici._


Funcția sigmoidă, caracterizată prin forma sa în „S”, realizează o mapare continuă a valorilor reale în intervalul (0, 1). Această proprietate o face adecvată pentru modelarea probabil
ităților în contexte aplicate, precum estimarea probabilității ca un client să achiziționeze un
produs sau ca un pacient să prezinte o anumită afecțiune.


_C10 Regresia logistica.nb_ **25**

#### **6. Implementare Practică**

## **Exemplu simplu**


Să presupunem că avem 3 observații:


( _x_ = 1, _y_ = 1),

( _x_ = 2, _y_ = 1),
( _x_ = 3, _y_ = 0),













Modelul este:


Log-likelihood-ul devine:



_z_ = β0 + β1 _x_ .



_l_ (β) = _ln_  1



1 1

1+ [-β][0][+β][1][][1][] [+] _[ ln]_ [] 1+ [-β][0]



1

1+ [-β][0][+β][1][][2][] [+] _[ ln]_ [] 1+ [][-β][-β][0][+β][0][+β][1][][1][3][][]



1+ [-β][0][+β][1][][3][] []



Folosinde posibilitățile de calcul ale sistemului Mathematica, obținem valorile numerice ale
coeficienților β0 și β1:


**26** _C10 Regresia logistica.nb_

















Așadar, modelul construit este următorul:


Să verificăm acest model pentru datele inițiale.


Pentru x = 1, probabilitatea ca y să fie egal cu 1 este 1:





Pentru x = 2, probabilitatea ca y să fie egal cu 1 este 1:







Pentru x = 3, probabilitatea ca y să fie egal cu 1 este 0:







Să estimăm probabilitatea pentru o valoare care nu este în setul de antrenament x = 2.6:


_C10 Regresia logistica.nb_ **27**







De fapt, putem construi graficul modelului construit:















Să estimăm probabilitatea pentru o valoare apropiată de punctul în care are loc schimbarea
valorii de la 1 la 0. Fie x = 2.51:







Remarcăm faptul că suntem în apropierea pragului care determină ce valoare discretă se
selectează pentru valoarea argumentului _x_ .

## **Rezumat**


La soluționarea unei probleme de regresie logistică sunt importante următoarele aspecte:

### **Obiectivul**


Se maximizează funcția log-likelyhood ℓ(β) pentru a găsi β pentru care datele sunt cele mai
probabile.


**28** _C10 Regresia logistica.nb_

### **Procedura de calcul**


Se calculează derivata funcției log-likelihood și se folosesc metode numerice (ex. metoda
gradientului) pentru a găsi soluția.

### **Rezultat**


Parametrii β estimați sunt folosiți ulterior pentru predicții în baza funcției logistice.


Metoda MLE este eficientă și robustă, fiind standardul pentru antrenarea regresiei logistice,
oferind estimări care se aliniază bine cu datele observate.


_C10 Regresia logistica.nb_ **29**

#### **7. Evaluarea modelului de clasificare**

## **Matricea de confuzie**


Cât de bun este modelul construit? Cum estimăm calitatea modelului?


Există mai multe moduri de a evalua un model de clasificare.


**Matricea de confuzie** (denumită și matricea erorilor; în rusă: матрица ошибок, uneori
матрица несоответствий sau неточностей) reprezintă un concept fundamental în evaluarea performanței algoritmilor de clasificare. Aceasta oferă o reprezentare tabelară a corespondenței dintre predicțiile modelului și etichetele reale (adevărul de referință).


În această matrice:


  - Fiecare **linie** corespunde **instanțelor prezise** ca aparținând unei anumite clase.


  - Fiecare **coloană** corespunde **instanțelor reale** din acea clasă.


Pentru un clasificator binar (двоичный классификатор), matricea de confuzie permite
analiza a patru tipuri de rezultate:


**1.** adevărat pozitive (true positive - **ТР**, истинно положительные) – modelul prezice corect

clasa pozitivă,


**2.** adevărat negative (true negative   - **TN**, истинно отрицательные)   - modelul prezice

corect clasa negativă,


**3.** fals pozitive (false positive - **FP**, ложно положительные) – modelul prezice pozitiv, dar

clasa este negativă,


**4.** fals negative (false negative - **FN**, ложно отрицательные) – modelul prezice negativ, dar

clasa este pozitivă.


Doar primele 2 rezultate sunt corecte (în tabel - culoarea verde).


**30** _C10 Regresia logistica.nb_


**Exemplu** :


Matricea de confuzie constituie baza pentru calcularea mai multor indicatori de evaluare a
modelului:
#### Acuratețea

Acuratețea clasificării este poate cea mai simplă metrică care care poate fi imaginată și
este definită ca numărul de predicții corecte împărțit la numărul total de predicții:


Accuracy = TP + TN
TP + TN + FP + FN


În exemplul de mai sus, din 1100 de exemplare 1030 sunt prezise corect, rezultând o
**acuratețe** de clasificare:














_C10 Regresia logistica.nb_ **31**


**Când se folosește** : Când clasele sunt echilibrate.


**Limitare** : Poate fi înșelătoare dacă datele sunt dezechilibrate (ex. 95% incorect prezise,
5% corect prezise). În exemplul nostru sunt negative doar 70 din 1100, adică doar circa 6%:








#### Precizia

_Adesea acuratețea clasificării nu este un indicator bun al performanței modelului_ . Unul
dintre aceste scenarii este atunci când _distribuția clasei este dezechilibrată_ (o clasă este
mai frecventă decât altele). În acest caz, chiar dacă se prezic toate exemplarele ca fiind
cea mai frecventă clasă, se obține o rată de acuratețe ridicată, ceea ce nu are deloc sens
(pentru că modelul nu învață nimic și doar prezice totul ca clasa de vârf). De exemplu, în
clasificarea de mai sus pisică vs non-pisică, dacă modelul prezice toate exemplarele ca
non-pisică, ar avea ca rezultat acuratețea 1000/1100= 90,9%.


Prin urmare, **trebuie să considerăm și metrici de performanță specifice clasei** . **Pre-**
**cizia** este una dintre astfel de metrici, care este definită ca:


Precision = TP
TP + FP







Așadar, precizia clasei Pisică din exemplul de mai sus poate fi calculată ca:

PreciziePisica = [NrExemplareCorectPrezisePisică]

NrTotalExemplarePrezisePisică










**32** _C10 Regresia logistica.nb_









Modelul are o precizie mult mai mare în prezicerea probelor non-pisici, comparativ cu pisici.
Nu este surprinzător, deoarece modelul a văzut mai multe exemplare de imagini non-pisică
în timpul antrenamentului, ceea ce îl face mai bun în clasificarea clasei respective.


**Când se folosește:** Când costul FP este mare (ex. diagnosticarea greșită a unei boli).

#### Rechemarea

**Rechemare** (Recall, Completitudine, Sensitivity sau True Positive Rate) este utilizată de
regulă în domeniile medicinii și biologiei și este definită ca (la acuratețe numitorul este TP +
FP):


Recall = TP
TP + FN









Prin urmare, pentru exemplul nostru de mai sus, rata de completitudine a claselor de pisici
și non-pisici poate fi găsită ca:










_C10 Regresia logistica.nb_ **33**





**Când se folosește** : Când costul FN este mai mare (ex. omiterea detectării unei boli)

#### Specificitatea

**Specificitatea** (Specificity; True Negative Rate) la fel este utilizată de regulă în domeniile
medicinii și biologiei și este definită ca:


Specificity = TN
TN + FP















**Când se folosește** : Când este important să identificăm corect negativele.

#### Scorul F1

În funcție de aplicație, se poate acorda o prioritate mai mare fie completitudinii / rechemării
(recall), fie preciziei. Dar există multe aplicații în care atât completitudinea / rechemarea
(recall), cât și precizia sunt importante. Prin urmare, este firesc să se aleagă o modalitate
de a integra ambele metrici în doar una. _O metrică populară care combină precizia și com-_
_pletitudinea/rechemare (recall) se numește scor F1_ . Această metrică reprezintă **media**
**armonică a preciziei și completitudini** i definită ca:


F1 = 2 [Precision][ ] [Recall]

Precision + Recall


**ScorF1 = 2** **[Precizie][ *][ Completitudine]**

**Precizie + Completitudine**


Pentru exemplul nostru de clasificare cu matricea de confuzie prezentată supra, scorul F1
poate fi calculat ca:






**34** _C10 Regresia logistica.nb_

















Versiunea generalizată a scorului F1 este definită după cum urmează, scorul F1 fiind un
caz special al lui _F_ β când β = 1:


**Fβ** **=**

**1 + β** **[2]** **((Precizie** ***** **Completitudine) / (Precizie** **+ Completitudine))**


Este bine de menționat că există întotdeauna un compromis între precizia și completitudinea unui model. Dacă se mărește precizia prea mult, se poate observa o scădere a
ratei de completitudine și invers.


**Când se folosește** : Când vrem un echilibru între precizie și recall.

#### Curba ROC și AUC Log-Loss-ul Validarea încrucișată Analiza coeficienților

## **Exemplu recapitulativ**


Să presupunem că un model de regresie logistică prezice dacă un pacient are o boală
(y=1) sau nu (y=0). Rezultatele pe un set de test sunt:


TP = 40, TN = 50, FP = 10, FN = 5.


**Acuratețe** :


_C10 Regresia logistica.nb_ **35**











**Precizie** :









**Recall** :









**F1-Score** :











Dacă AUC = 0.9, modelul are o bună capacitate de discriminare.

## **Considerații finale**


**Dezechilibrul claselor** : Dacă datele sunt dezechilibrate (ex. 90% negative), metrici precum F1 sau AUC sunt preferabile față de acuratețe.


**Obiectivul problemei** : Alegerea metricii depinde de priorități (ex. minimizarea FN în diagnosticul medical vs. FP în detectarea spamului).


**Compararea modelelor** : Metrici precum AUC sau log-loss sunt utile pentru a compara
performanța diferitelor modele.


**36** _C10 Regresia logistica.nb_


Evaluarea unui model de regresie logistică implică, așadar, o combinație de metrici cantitative (acuratețe, F1, AUC etc.) și analize calitative (interpretarea coeficienților), adaptate la
contextul specific al problemei.


_O u t [_  _] =_


























|Metrică|Formulă|Interpretare|🇷🇺|
|---|---|---|---|
|Acuratețe|TP + TN<br>TP + TN + FP + FN|Proporția<br>totală de<br>predicții corecte|Точность (Accuracy)|
|Precizie|TP<br>TP + FP|Cât de corecte<br>sunt predicțiile<br>pozitive|Точность<br>положительных|
|Recall /<br>Sensibilitate|TP<br>TP + FN|Cât de bine<br>sunt detectate<br>cazurile pozitive|Полнота /<br>Чувствительность|
|Specificitate|TN<br>TN + FP|Cât de bine<br>sunt detectate<br>cazurile negative|Специфичность|
|Fals Pozitiv Rate|FP<br>FP + TN|Proporția<br>de negative<br>clasificate<br>greșit ca<br>pozitive|Доля ложных<br>положительных|
|Fals Negativ Rate|FN<br>FN + TP|Proporția<br>de pozitive<br>clasificate<br>greșit ca<br>negative|Доля ложных<br>отрицательных|
|Scor F1|2<br>Precizie × Recall<br>Precizie + Recall|Echilibru<br>între precizie<br>și recall|F1-мера|
|Prevalență|TP + FN<br>Total|Proporția<br>de instanțe<br>pozitive în<br>setul de date|Распространенность|
|Negative<br>Predictive Value|TN<br>TN + FN|Cât de corecte<br>sunt predicțiile<br>negative|Точность<br>отрицательных|
|Balanced Accuracy|Recall + Specificity<br>2|Medie între<br>sensibilitate<br>și specificitate|Сбалансированная<br>точность|


_C10 Regresia logistica.nb_ **37**


**38** _C10 Regresia logistica.nb_

#### **8. Overfitting și underfitting**

## **Overfitting (supra-învățare)** **Underfitting (sub-învățare)** **Cum se detectează?** **Cum se corectează?** **Exemplu în regresia logistică** **Concluzie**


_C10 Regresia logistica.nb_ **39**

#### **9. Probleme și extensii**

## **Probleme-dificultăți** **Regresia Multiclasă**


**40** _C10 Regresia logistica.nb_

#### **10. Concluzii**


Să prezentăm câteva concluzii succinte asupra regresiei logistice:


  - **Utilitate** : Este un algoritm fundamental de clasificare, eficient pentru predicția probabil
ităților în probleme binare sau multinomiale (cu extensii precum softmax).


  - **Simplitate** : Bazată pe o combinație liniară transformată prin funcția sigmoidă, este ușor

de implementat și interpretat.


  - **Avantaje** : Interpretabilă (coeficienții indică influența variabilelor), robustă pe date liniare

sau aproape liniare, necesită puține resurse computaționale.


  - **Limitări** : Presupune liniaritate în log-odds, este sensibilă la date dezechilibrate, outliers și

multicoliniaritate, și performează slab pe date complexe/neliniare.


  - **Evaluare** : Se folosește matricea de confuzie, metrici (acuratețe, precizie, recall, F1),
curba ROC/AUC și log-loss pentru a măsura performanța.


  - **Aplicații practice** : Diagnostic medical, analiza riscului de credit, detectarea spam-ului,
predicția comportamentului clienților.


  - **Optimizare** : Parametrii sunt estimați prin maximizarea likelihood-ului, folosind metode

numerice precum este metoda gradientului.


  - **Flexibilitate** : Poate fi extinsă (ex. OvR, OvO) pentru multiclasă, dar nu este ideală pentru
multi-label sau relații neliniare complexe.


 **În esență** : _Regresia logistică este o unealtă valoroasă pentru o clasificare simplă și inter-_

_pretabilă_ . Pentru obținerea unor rezultate optime necesită o gestionare atentă a supozițiilor
și limitărilor sale.


_C10 Regresia logistica.nb_ **41**

#### **11. Materiale Adiționale**


Pentru a înțelege în profunzime regresia logistică, există numeroase surse bibliografice de
calitate, atât cărți clasice, cât și resurse online. Iată o selecție a celor mai bune surse,
împărțite pe categorii, care acoperă teoria, aplicațiile practice și implementarea:

#### **Cărți clasice** **Cursuri și resurse online** **Documentație și tutoriale practice**


**42** _C10 Regresia logistica.nb_

#### **Setări**

## ◼ Setări notebook ◼ Setări celule


