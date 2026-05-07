#### **1. Analiza varianței - ANOVA Дисперсионный анализ**

# ◼ Rolul în Curs: Tranziția spre Complexitate

ANOVA reprezintă „podul” metodologic de la inferența clasică (Testul t pentru două eșantioane) către analiza multi-grup. Este fundamentul designului experimental, permițând
compararea simultană a mai multor populații fără a compromite rigoarea statistică.


ANOVA представляет собой **методологический** « **мост** » от классического
статистического вывода (t-критерий для двух выборок) к **многогрупповому анализу** .
Она является фундаментом **экспериментального** **дизайна**, позволяя
**одновременно сравнивать несколько генеральных совокупностей**, не нарушая
статистическую строгость.

# ◼ Obiective


La finalul acestei unități, vom fi capabili să:

   - **Fundamentăm Ipotezele** : Formulăm corect ipoteza nulă ( _H_ 0: egalitatea mediilor) și
ipoteza alternativă ( _H_ 1: cel puțin o medie diferă).

   - **Înțelegem** **Riscul** **(Alpha** **Inflation)** : Explicăm de ce utilizarea testelor t multiple
crește riscul de eroare de tip I și de ce ANOVA este soluția corectă.
Мы объясняем, почему использование множественных t-критериев увеличивает
риск ошибки первого рода и почему ANOVA является корректным решением.

   - **Decompunem Varianța** : Derivăm și interpretăm componentele variației: SST = SSB
+ SSW (Variația între grupuri vs. Variația în interiorul grupurilor).
Разлагаем дисперсию: выводим и интерпретируем компоненты вариации: SST =
SSB + SSW (межгрупповая вариация vs. внутригрупповая вариация).

   - **Executăm și Validăm** : Aplicăm modelul ANOVA One-Way și verificăm ipotezele
critice (normalitate, omogenitatea varianțelor/homoscedasticitate).
Выполняем и проверяем: применяем однофакторную модель ANOVA (One-Way
ANOVA) и проверяем критические предпосылки (нормальность, однородность
дисперсий / гомоскедастичность).

   - **Interpretăm** **Inferențial** : Extragem concluzii statistice și contextuale din tabelul
ANOVA și testele Post-Hoc.
Интерпретируем на уровне статистического вывода: извлекаем **статистические**
**и контекстуальные выводы** из **таблицы ANOVA** и **пост-хок тестов** .


**2** _C7 ANOVA.nb_

# ◼ Ilustrație grafică prealabilă


_O u t [_  _] =_

#### **LOGICA ANOVA: Decompoziția Varianței**

Vizualizarea raportului dintre Semnal (SSB) și Zgomot (SSW)


4.0



3.5


3.0


2.5


2.0


1.5



|medii de grup|Col2|Col3|Col4|
|---|---|---|---|
||SSW (în interior)<br>SSB (între grupuri)|SSW (în interior)<br>SSB (între grupuri)||
|_y2_<br>**SSB (semnal)**<br>media globală (ȳ)<br>_y1_ (medie de grup)|_y2_<br>**SSB (semnal)**<br>media globală (ȳ)<br>_y1_ (medie de grup)|_y2_<br>**SSB (semnal)**<br>media globală (ȳ)<br>_y1_ (medie de grup)|_y2_<br>**SSB (semnal)**<br>media globală (ȳ)<br>_y1_ (medie de grup)|
|||**_media globală_ (****_ȳ_)**|**_media globală_ (****_ȳ_)**|
|||||
|_y3_|_y3_|||
|_y1_<br>**SSW (zgomot)**|_y1_<br>**SSW (zgomot)**|_y1_<br>**SSW (zgomot)**|_y1_<br>**SSW (zgomot)**|


**G1** **G2** **G3**





Această diagramă este o reprezentare vizuală a **logicii fundamentale a testului ANOVA**
**(Analysis of Variance)** . Ea explică modul în care statistica descompune variația totală din
date pentru a decide dacă grupurile analizate sunt cu adevărat diferite între ele.


Iată principalele elemente explicate:

### **◻ 1. Grupurile și Variația în Interior (SSW - Sum of Squares Within)**


Cele trei cercuri colorate (Albastru, Verde, Roșu) reprezintă cele trei grupuri comparate (de
exemplu: trei metode de predare diferite sau trei tipuri de tratament).


 - **Aria discurilor** : Reprezintă răspândirea datelor în interiorul fiecărui grup.


_C7 ANOVA.nb_ **3**


  - **Săgețile color verticale (SSW)** : Acesta este **„Zgomotul** ”. Ele măsoară cât de mult

variază indivizii în interiorul aceluiași grup. În statistică, numim aceasta „eroare” sau
variație reziduală, deoarece nu poate fi explicată de apartenența la grup (toți cei din G1
au primit același tratament, dar totuși au scoruri diferite).


Цветные вертикальные стрелки (SSW): это «шум». Они измеряют, насколько сильно
варьируются отдельные наблюдения внутри одной и той же группы. В статистике
это называется «ошибкой» или остаточной вариацией, поскольку она не может
быть объяснена принадлежностью к группе (все участники группы G1 получили
одно и то же воздействие, однако их значения различаются).

### **◻ 2. Mediile de Grup și Variația Între Grupuri (SSB - Sum of Squares** **Between)**

Liniile orizontale groase din centrul cercurilor reprezintă mediile fiecărui grup ( _y_ 1, _y_ 2, _y_ 3).


  - **Săgețile oblice (SSB)** : Acesta este „Semnalul”. Ele măsoară cât de departe sunt mediile

grupurilor unele de altele.


Наклонные стрелки (SSB): это «сигнал». Они показывают, насколько средние
значения групп удалены друг от друга.


  - **Logica** : Dacă aceste săgeți sunt lungi, înseamnă că grupurile sunt foarte diferite. Dacă

sunt scurte, mediile sunt aproape una de alta, sugerând că nu există un efect real al
factorului analizat.

### **◻ 3. Media Globală (Grand Mean)**


Linia punctată gri care traversează tot graficul reprezintă media tuturor subiecților, indiferent de grup.


  - ANOVA verifică dacă mediile grupurilor „gravitează” aproape de această linie (caz în care

_H_ 0 este adevărată) sau dacă s-au îndepărtat semnificativ de ea (caz în care avem un
efect statistic).

### **◻ 4. Raționamentul Statisticii F**


Întreaga diagramă se rezumă la calculul indicelui F, care este raportul dintre cele două
tipuri de variație:


Вся диаграмма сводится к вычислению F-критерия — отношения межгрупповой и
внутригрупповой дисперсии.



_F_ =



Variația Între Grupuri (Semnal)


Variația În Interiorul Grupurilor (Zgomot)



**Dacă F este mare** : Înseamnă că „Semnalul” (săgețile negre) este mult mai puternic decât
„Zgomotul” (săgețile color). Concluzionăm că există diferențe semnificative între grupuri.


**4** _C7 ANOVA.nb_


**Dacă F este mic (aproape de 1)** : Înseamnă că diferențele dintre medii sunt la fel de mici
ca variația naturală dintre oameni. Concluzionăm că diferențele observate sunt pur
întâmplătoare.

### **◻ Concluzie**


Diagrama ne învață că, pentru a avea un rezultat semnificativ în cercetare, nu este suficient ca mediile să fie diferite (SSB mare); trebuie ca și grupurile să fie „compacte” (SSW
mic). Dacă grupurile au o variație internă uriașă (cercuri foarte mari care se suprapun), va fi
imposibil să demonstrăm că ele provin din populații diferite.


Диаграмма показывает, что для получения **статистически значимого результата** в
исследовании недостаточно того, чтобы **средние** **значения** **групп** **различались**
(большая SSB); необходимо также, чтобы сами группы были « **компактными** » (малая
SSW). Если группы характеризуются **очень большой внутригрупповой дисперсией**
(очень большие, перекрывающиеся круги), будет невозможно доказать, что они
происходят из **разных генеральных совокупностей** .

# ◼ Tabelul ANOVA în prealabil

















|Sursa<br>Variației|Suma<br>Pătratelor (SS)|Grade de<br>Libertate (df)|Media<br>Pătratelor (MS)|Statistica F|
|---|---|---|---|---|
|**Între Grupuri**<br>**(Semnal)**|SSB|k - 1|MSB =<br>SSB<br>k - 1|**F =**<br>MSB<br>MSW|
|**În Interior**<br>**(Zgomot)**|SSW|N - k|MSW =<br>SSW<br>N - k||
|**Total**|SST = SSB + SSW|N - 1|||


**k**  - numărul de grupuri,
**N** - numărul total de subiecți,
**SSW** (Sum of Squares Within),
**SSB** (Sum of Squares Between),
**SST** (Sum of Squares Total),
**df**  - gradele de libertate.

### **◻ Statistica F (Raportul Semnal/Zgomot)**


Este rezultatul final.


 - Dacă F = 1, semnalul este egal cu zgomotul (nimic interesant).


_C7 ANOVA.nb_ **5**


  - Dacă F > 1 (de obicei peste 3-4, depinzând de df), semnalul domină zgomotul.

### **◻ Interpretarea Finală (Regula de Aur)**


După ce calculăm _F_, Mathematica sau orice soft statistic ne dă un _p_ -value:


  - Dacă p < 0.05: Respingem _H_ 0. Grupurile sunt diferite. (Săgețile dintre grupuri din dia
grama noastră sunt prea lungi pentru a fi o coincidență).


  - Dacă p > 0.05: Menținem _H_ 0. Orice diferență vedem între grupuri este doar „zgomot” de

eșantionare.


**Atenție** ! ANOVA ne spune că există o diferență, dar nu ne spune unde (nu știm dacă G1 e
diferit de G2 sau G2 de G3). Pentru asta, avem nevoie de **Testele Post-Hoc** (spre exemplu, testul Tukey).


**6** _C7 ANOVA.nb_

#### **2. Motivarea Problemei: De ce ANOVA?**

# ◼ Întrebarea Fundamentală


   - Atunci când comparăm k ≥ 3 grupuri (ex: eficiența a trei medicamente diferite), întrebarea nu este doar „Sunt mediile diferite?”, ci:

     - „Există dovezi că cel puțin una dintre populații diferă de celelalte, sau variația
observată este pur întâmplătoare?”
### **◻ Contextul utilizării:**

   - **Variabila dependentă** : Cantitativă (ex: scoruri, timp de reacție, venit).

   - **Variabila independentă** : Categorică (un factor cu 3 sau mai multe niveluri).

Atfel spus:


   - date cantitative

   - grupuri definite de un factor categoric

# ◼ Capcana Testelor t Multiple


Cea mai frecventă greșeală este compararea grupurilor „pereche cu pereche” folosind mai
multe teste t.


   - fiecare test t → eroare de tip I

   - eroarea cumulată crește rapid

### **◻ Problema: Inflația Erorii de Tip I (α)**


Fiecare test statistic vine cu un risc de eroare α (de obicei 0.05 sau 5%). Dacă efectuăm
mai multe teste independente, riscul de a găsi o „diferență falsă” (Eroare de Tip I) crește
exponențial:


_P_ (Eroare globală) = 1 - (1 - α) _[c]_


unde c este numărul de comparații.


Limitarea testelor t


   - fiecare test t are nivel de semnificație α

   - mai multe teste ⇒ eroare de tip I cumulată

### **◻ Exemplu: Efectul de „Bulgăre de Zăpadă”**

Dacă avem 4 grupuri, sunt necesare _C_ 24 = 6 teste _t_ pentru a acoperi toate combinațiile.


La un α = 0.05 per test, riscul global de eroare devine:


_P_ (Eroare globală) = 1 - (1 - 0.05) [6] ≈ 0.26, adică 26%.


_C7 ANOVA.nb_ **7**


**Concluzie** : Avem o șansă de peste 1/4 să declarăm o diferență „semnificativă” care, în
realitate, nu există.

# ◼ Mesaj-Cheie: ANOVA ca „Scut Statistic”


ANOVA rezolvă această criză printr-o abordare dintr-un singur pas:


**1.** **Test Global (Omnibus)** : Testează simultan toate mediile într-un singur proces.


**2.** **Controlul Erorii** : Menține eroarea de tip I la nivelul setat (ex. 5%) pentru întreaga familie

de comparații.


**3.** **Eficiență** : Detectează dacă merită să „săpăm” mai adânc. Dacă ANOVA nu este semni
ficativă, ne oprim (protejându-ne de rezultate fals-pozitive).


ANOVA testează simultan toate mediile, menținând controlul erorii.

### **◻ Analogie**


  - **Testul** _**t**_ : Este ca un arbitru care verifică dacă doi jucători au faultat.


  - **ANOVA** : Este ca un sistem de monitorizare video (VAR) care scanează întreg terenul

(toate grupurile) pentru a vedea dacă a existat vreo neregulă oriunde în meci.


**8** _C7 ANOVA.nb_

#### **3. Ideea Fundamentală: Principiul Comparației**


ANOVA nu compară mediile direct (prin scădere, ca la testul t), ci analizează sursele variabilității pentru a deduce dacă mediile sunt diferite.

# ◼ Cele Două Componente ale Varianței


  - Variația **ÎNTRE** Grupuri (Between-Groups Variance)


   - **Ce măsoară** : Distanța dintre mediile eșantioanelor.

   - **Semnificație** : Reprezintă **SEMNALUL** . Cu cât mediile sunt mai îndepărtate, cu atât

credem mai mult că factorul studiat are un efect real.

  - Variația **ÎN INTERIORUL** Grupurilor (Within-Groups Variance)


   - **Ce măsoară** : Diferențele dintre indivizii aceluiași grup (dispersia datelor).

   - **Semnificație** : Reprezintă **ZGOMOTUL** (eroarea). Este variația naturală, care nu
poate fi explicată prin apartenența la un grup sau altul.

# ◼ Intuiția Statisticii F: Raportul Semnal/Zgomot:


Decizia statistică se bazează pe balanța dintre aceste două forțe: semnal și zgomot. Imaginați-vă un raport:



_F_ =



Variația **ÎNTRE** (Semnal)


Variația **ÎN INTERIOR** (Zgomot)




- **Dacă mediile diferă real** : Variația dintre grupuri va domina. Valoarea lui _F_ va fi mult

mai mare decât 1. Semnalul „iese deasupra” zgomotului.

- **Dacă mediile sunt egale (H₀)** : Variația dintre grupuri va fi aproximativ egală cu variația internă. Valoarea lui _F_ va fi aproape de 1. Tot ce vedem este doar zgomot de
eșantionare.


_C7 ANOVA.nb_ **9**

### **◻ Mesaj Vizual: Când respingem Ipoteza Nulă?**








|Scenariul<br>statisti-<br>cii F|Interpretare vizuală<br>(Semnal vs. Zgomot)|Decizie inferențială|
|---|---|---|
|**F < 1**|Zgomotul intern (SSW)<br>domină semnalul.<br>Diferențele dintre<br>medii sunt mici față de<br>dispersia din grupuri.|**Nu respingem H₀.**<br>**Diferențele observate**<br>**sunt prea mici pentru**<br>**a susține un efect real.**|
|**F ≈1**|Semnalul este<br>comparabil cu zgomotul.<br>Efectul observat<br>este compatibil cu<br>variația aleatorie.|**Nu respingem H₀.**<br>**Diferențele dintre**<br>**grupuri pot fi explicate**<br>**prin variabilitatea**<br>**de eșantionare.**|
|**F > 1,**<br>**dar p**<br>**≥0.05**|Semnalul depășește<br>zgomotul, dar nu<br>suficient de mult pentru<br>a exclude întâmplarea.|**Nu respingem H₀.**<br>**Există o tendință,**<br>**dar rezultatul nu este**<br>**semnificativ statistic.**|
|**F ≫1,**<br>**cu p**<br>**< 0.05**|**Semnalul dintre grupuri**<br>**este clar mai mare**<br>**decât zgomotul intern.**<br>**Separarea mediilor**<br>**este prea mare**<br>**pentru a fi atribuită**<br>**doar hazardului.**|**Respingem H₀.**<br>**Există diferențe**<br>**semnificative statistic**<br>**între mediile grupurilor.**|
|**Regula de**<br>**decizie**|_Decizia finală în ANOVA se_<br>_bazează pe comparația_<br>_dintre p_-_value și pragul_<br>_de semnificație_ α_ ._|**Dacă p < 0.05:**<br>**respingem H₀.**<br>**Dacă p ≥0.05:**<br>**nu respingem H₀.**|



In[1]:=



**ClearAll[scenarioTable];**



**scenarioTable** **=**
**Print@** **Module[**

**{**

**headerBG** **=** **RGBColor["#334155"],**
**weakColor** **=** **RGBColor["#64748B"],**
**balancedColor** **=** **RGBColor["#0D9488"],**
**cautionColor** **=** **RGBColor["#EA580C"],**
**strongColor** **=** **RGBColor["#DC2626"],**
**decisionColor** **=** **RGBColor["#B45309"],**
**textDark** **=** **GrayLevel[0.2],**
**frameCol** **=** **GrayLevel[0.83],**


**10** _C7 ANOVA.nb_


**bg1** **=** **White,**
**bg2** **=** **RGBColor["#F8FAFC"],**
**bg3** **=** **RGBColor["#FFF7ED"],**
**bg4** **=** **RGBColor["#FFF1F2"],**
**bg5** **=** **RGBColor["#FFFBEB"],**
**approxSym** **=** **"≈"**
**},**


**Framed[**
**Grid[**

**{**

**{**

**Item[**
**Style["Сценарий** **статистики** **F",** **12,** **Bold,** **White],**
**Background** **** **headerBG,** **Alignment** **** **Center**
**],**
**Item[**
**Style["Визуальная** **интерпретация\n(Сигнал** **vs.** **Шум)",** **12,** **Bold,** **White],**
**Background** **** **headerBG,** **Alignment** **** **Center**
**],**
**Item[**
**Style["Инференционное** **решение",** **12,** **Bold,** **White],**
**Background** **** **headerBG,** **Alignment** **** **Center**

**]**

**},**


**{**

**Item[**
**Style["F** **<** **1",** **14,** **Bold,** **weakColor],**
**Background** **** **bg1,** **Alignment** **** **Center**
**],**
**Item[**
**Style[**
**"Внутренний** **шум** **(SSW)** **доминирует** **над** **сигналом.\nРазличия** **между** **средними** **малы** **по**
**11,** **textDark**
**],**
**Background** **** **bg1,** **Alignment** **** **Left**
**],**
**Item[**
**Style[**
**"Мы** **не** **отвергаем** **H₀.\nНаблюдаемые** **различия** **слишком** **малы,** **чтобы** **подтверждать** **реа**
**11,** **Bold,** **weakColor**
**],**
**Background** **** **bg1,** **Alignment** **** **Left**

**]**

**},**


**{**

**Item[**
**Style["F** **"** **<>** **approxSym** **<>** **"** **1",** **14,** **Bold,** **balancedColor],**
**Background** **** **bg2,** **Alignment** **** **Center**


_C7 ANOVA.nb_ **11**


**],**
**Item[**
**Style[**
**"Сигнал** **сопоставим** **с** **шумом.\nНаблюдаемый** **эффект** **совместим** **со** **случайной** **вариацие**
**11,** **textDark**
**],**
**Background** **** **bg2,** **Alignment** **** **Left**
**],**
**Item[**
**Style[**
**"Мы** **не** **отвергаем** **H₀.\nРазличия** **между** **группами** **могут** **быть** **объяснены** **выборочной** **в**
**11,** **Bold,** **balancedColor**
**],**
**Background** **** **bg2,** **Alignment** **** **Left**

**]**

**},**


**{**

**Item[**
**Style["F** **>** **1,** **но** **p** **≥** **0.05",** **13,** **Bold,** **cautionColor],**
**Background** **** **bg3,** **Alignment** **** **Center**
**],**
**Item[**
**Style[**
**"Сигнал** **превышает** **шум,** **но** **недостаточно** **сильно,\nчтобы** **исключить** **случайность.",**
**11,** **textDark**
**],**
**Background** **** **bg3,** **Alignment** **** **Left**
**],**
**Item[**
**Style[**
**"Мы** **не** **отвергаем** **H₀.\nНаблюдается** **тенденция,** **но** **результат** **не** **является** **статистич**
**11,** **Bold,** **cautionColor**
**],**
**Background** **** **bg3,** **Alignment** **** **Left**

**]**

**},**


**{**

**Item[**
**Style["F** **≫** **1,** **при** **p** **<** **0.05",** **13,** **Bold,** **strongColor],**
**Background** **** **bg4,** **Alignment** **** **Center**
**],**
**Item[**
**Style[**
**"Межгрупповой** **сигнал** **явно** **больше** **внутреннего** **шума.\nРазделение** **средних** **слишком**
**11,** **Bold,** **textDark**
**],**
**Background** **** **bg4,** **Alignment** **** **Left**
**],**
**Item[**


**12** _C7 ANOVA.nb_


**Style[**
**"Мы** **отвергаем** **H₀.\nСуществуют** **статистически** **значимые** **различия** **между** **средними** **зн**
**11,** **Bold,** **strongColor**
**],**
**Background** **** **bg4,** **Alignment** **** **Left**

**]**

**},**


**{**

**Item[**
**Style["Правило** **принятия** **решения",** **12,** **Bold,** **White],**
**Background** **** **decisionColor,** **Alignment** **** **Center**
**],**
**Item[**
**Style[**
**"Окончательное** **решение** **в** **ANOVA** **основывается** **на** **сравнении** **p-value** **с** **уровнем** **знач**
**11,** **Italic,** **textDark**
**],**
**Background** **** **bg5,** **Alignment** **** **Left**
**],**
**Item[**
**Style[**
**"Если** **p** **<** **0.05:** **отвергаем** **H₀.\nЕсли** **p** **≥** **0.05:** **не** **отвергаем** **H₀.",**
**11,** **Bold,** **decisionColor**
**],**
**Background** **** **bg5,** **Alignment** **** **Left**

**]**

**}**

**},**


**Frame** **** **All,**
**FrameStyle** **** **frameCol,**
**Spacings** **{1.4,** **2.0},**
**Alignment** **{{Center,** **Left,** **Left},** **Center},**
**ItemSize** **{{7,** **15,** **15},** **Automatic},**
**BaseStyle** **{FontFamily** **** **"Helvetica"}**
**],**


**RoundingRadius** **** **8,**
**FrameStyle** **** **GrayLevel[0.72],**
**Background** **** **White,**
**FrameMargins** **** **8**

**]**

**]**


_C7 ANOVA.nb_ **13**








|Сценарий<br>статис-<br>тики<br>F|Визуальная<br>интерпретация<br>(Сигнал vs. Шум)|Инференционное<br>решение|
|---|---|---|
|**F < 1**|Внутренний шум<br>(SSW) доминирует<br>над сигналом.<br>Различия между средними<br>малы по сравнению с<br>разбросом внутри групп.|**Мы не отвергаем H₀.**<br>**Наблюдаемые различия**<br>**слишком малы,**<br>**чтобы подтверждать**<br>**реальный эффект.**|
|**F ≈1**|Сигнал сопоставим<br>с шумом.<br>Наблюдаемый<br>эффект совместим со<br>случайной вариацией.|**Мы не отвергаем H₀.**<br>**Различия между**<br>**группами могут**<br>**быть объяснены**<br>**выборочной**<br>**вариабельностью.**|
|**F > 1, но p**<br>**≥0.05**|Сигнал превышает шум, но<br>недостаточно сильно,<br>чтобы исключить<br>случайность.|**Мы не отвергаем H₀.**<br>**Наблюдается**<br>**тенденция, но**<br>**результат не является**<br>**статистически**<br>**значимым.**|
|**F ≫1,**<br>**при p**<br>**< 0.05**|**Межгрупповой**<br>**сигнал явно больше**<br>**внутреннего шума.**<br>**Разделение средних**<br>**слишком велико,**<br>**чтобы его можно**<br>**было объяснить**<br>**только случайностью.**|**Мы отвергаем H₀.**<br>**Существуют**<br>**статистически**<br>**значимые различия**<br>**между средними**<br>**значениями групп.**|
|**Правило**<br>**принят-**<br>**ия**<br>**решен-**<br>**ия**|_Окончательное решение в_<br>_ANOVA основывается_<br>_на сравнении p_-_value с_<br>_уровнем значимости_ α_ ._|**Если p < 0.05:**<br>**отвергаем H₀.**<br>**Если p ≥0.05:**<br>**не отвергаем H₀.**|


### **◻ Cod Wolfram: Vizualizarea Raportului F**

Acest mic utilitar compară vizual două scenarii pentru a fixa conceptul:


**14** _C7 ANOVA.nb_


**F mic** **(zgomotul domină)** **F mare** **(semnalul domină)**


In[3]:=


**ClearAll[**
**groupColors,** **colorSSB,** **colorSSW,**
**fInterpretation,** **fDecisionColor,** **fFormalDecision,**
**compactLegend,** **fCompactBox,**
**anovaGraphicCompact,** **anovaCompactInterface**
**];**


**(*** **========================================** ***)**

**(*** **IDENTITATE** **VIZUALA** ***)**

**(*** **========================================** ***)**


**groupColors** **=** **{**
**RGBColor["#3B82F6"],**
**RGBColor["#10B981"],**
**RGBColor["#EF4444"]**
**};**


**colorSSB** **=** **RGBColor["#6366F1"];**
**colorSSW** **=** **RGBColor["#F59E0B"];**


**(*** **========================================** ***)**


_C7 ANOVA.nb_ **15**


**(*** **LOGICA** ***)**

**(*** **========================================** ***)**


**fInterpretation[f_]** **:=** **Which[**
**f** **<** **.9,** **"Zgomot** **dominant",**
**.9** **≤** **f** **≤** **1.1,** **"Echilibru** **(F** **≈** **1)",**
**True,** **"Semnal** **dominant"**
**];**


**fDecisionColor[f_]** **:=** **Which[**
**f** **<** **.9,** **colorSSW,**
**.9** **≤** **f** **≤** **1.1,** **GrayLevel[.45],**
**True,** **colorSSB**
**];**


**fFormalDecision[f_,** **fCrit_]** **:=** **If[**
**f** **>** **fCrit,**
**"RESPINGEM** **H0",**
**"NU** **respingem** **H0"**
**];**


**(*** **========================================** ***)**

**(*** **LEGENDA** ***)**

**(*** **========================================** ***)**


**compactLegend** **:=** **Framed[**
**Row[**

**{**

**Graphics[**
**{Opacity[.18],** **GrayLevel[.55],** **Disk[{0,** **0},** **Offset[4]]},**
**ImageSize** **** **15**
**],**
**Style["** **Eșantion** **",** **10,** **GrayLevel[.40]],**


**Graphics[**
**{GrayLevel[.45],** **Dashed,** **AbsoluteThickness[1.2],**
**Line[{{0,** **0},** **{1.2,** **0}}]},**
**ImageSize** **** **22**
**],**
**Style["** **Media** **globală** **",** **10,** **GrayLevel[.40]],**


**Graphics[**
**{Directive[colorSSB,** **AbsoluteThickness[2]],** **Arrowheads[.22],**
**Arrow[{{0,** **0},** **{1.2,** **0}}]},**
**ImageSize** **** **22**
**],**
**Style["** **SSB** **",** **10,** **Bold,** **colorSSB],**


**Graphics[**
**{Directive[colorSSW,** **AbsoluteThickness[2]],** **Arrowheads[.22],**
**Arrow[{{0,** **0},** **{1.2,** **0}}]},**


**16** _C7 ANOVA.nb_


**ImageSize** **** **22**
**],**
**Style["** **SSW",** **10,** **Bold,** **colorSSW]**
**},**
**Alignment** **** **Center**
**],**
**Background** **** **White,**
**FrameStyle** **** **Directive[GrayLevel[.88],** **AbsoluteThickness[1]],**
**RoundingRadius** **** **6,**
**FrameMargins** **{{8,** **8},** **{6,** **6}}**
**];**


**(*** **========================================** ***)**

**(*** **CASETA** **F** ***)**

**(*** **========================================** ***)**


**fCompactBox[f_,** **fCrit_]** **:=** **Module[**
**{mainColor,** **bgCol,** **rejectedQ,** **decisionColor,** **boxContent},**


**rejectedQ** **=** **f** **>** **fCrit;**
**mainColor** **=** **fDecisionColor[f];**
**decisionColor** **=** **If[rejectedQ,** **colorSSB,** **GrayLevel[.45]];**
**bgCol** **=** **If[rejectedQ,** **Lighter[colorSSB,** **.97],** **GrayLevel[.985]];**


**boxContent** **=**
**Column[**

**{**

**Style["STATISTICA** **F",** **10,** **Bold,** **GrayLevel[.50]],**


**Framed[**
**Style[NumberForm[f,** **{4,** **2}],** **30,** **Bold,** **mainColor],**
**Background** **** **White,**
**FrameStyle** **** **Directive[mainColor,** **AbsoluteThickness[1.5]],**
**RoundingRadius** **** **6,**
**FrameMargins** **{{16,** **16},** **{8,** **8}}**
**],**


**Style[fInterpretation[f],** **11,** **Bold,** **mainColor],**
**Style["Prag** **intuitiv:** **F** **=** **1",** **9,** **GrayLevel[.45]],**


**Spacer[4],**


**Style["REGULA** **STATISTICA",** **9.5,** **Bold,** **GrayLevel[.50]],**
**Style["Formal:** **comparam** **F** **cu** **Fcrit",** **8.5,** **Italic,** **GrayLevel[.42]],**


**Style[**
**"Fcrit** **=** **"** **<>** **ToString[NumberForm[fCrit,** **{3,** **2}]],**
**9.5,** **Bold,** **GrayLevel[.35]**
**],**


**Framed[**


_C7 ANOVA.nb_ **17**


**Style[fFormalDecision[f,** **fCrit],** **11,** **Bold,** **decisionColor],**
**Background** **** **If[rejectedQ,** **Lighter[colorSSB,** **.90],** **White],**
**FrameStyle** **** **Directive[decisionColor,** **AbsoluteThickness[1]],**
**RoundingRadius** **** **5,**
**FrameMargins** **{{10,** **10},** **{6,** **6}}**

**]**

**},**
**Alignment** **** **Center,**
**Spacings** **** **0.62**
**];**


**Framed[**
**Pane[**
**boxContent,**
**{195,** **230},**
**Alignment** **{Center,** **Center}**
**],**
**Background** **** **bgCol,**
**FrameStyle** **** **Directive[GrayLevel[.84],** **AbsoluteThickness[1]],**
**RoundingRadius** **** **10,**
**FrameMargins** **** **14,**
**ImageSize** **{225,** **275}**

**]**

**];**


**(*** **========================================** ***)**

**(*** **GRAFIC** **ANOVA** ***)**

**(*** **========================================** ***)**


**anovaGraphicCompact[means_List,** **radii_List]** **:=** **Module[**

**{**

**xs** **=** **{1.7,** **3.8,** **5.9},**
**yBar,**
**sigIdx,**
**sigLen,**
**noiseLen,**
**xA** **=** **0.35,**
**scale** **=** **1.4**
**},**


**yBar** **=** **Mean[means];**
**sigIdx** **=** **First** **@** **Ordering[Abs[means** **-** **yBar],** **-1];**


**sigLen** **=** **scale*Clip[Abs[means〚sigIdx〛-** **yBar],** **{.15,** **1.2}];**
**noiseLen** **=** **scale*Clip[Mean[radii],** **{.15,** **.9}];**


**Graphics[**

**{**

**(*** **Discuri** ***)**
**MapThread[**

**{**


**18** _C7 ANOVA.nb_


**Directive[#4,** **Opacity[.15]],**
**Disk[{#1,** **#2},** **Offset[30** **#3]],**
**Directive[#4,** **Opacity[.45],** **AbsoluteThickness[1]],**
**Circle[{#1,** **#2},** **Offset[30** **#3]]**
**}** **&,**
**{xs,** **means,** **radii,** **groupColors}**
**],**


**(*** **Media** **globala** ***)**

**{**

**Directive[GrayLevel[.45],** **Dashed,** **AbsoluteThickness[1.2]],**
**Line[{{1.05,** **yBar},** **{6.95,** **yBar}}]**
**},**


**(*** **Mediile** **grupurilor** ***)**
**MapThread[**

**{**

**Directive[Darker[#3,** **.25],** **AbsoluteThickness[3]],**
**Line[{{#1** **-** **.45,** **#2},** **{#1** **+** **.45,** **#2}}],**
**Text[**
**Style[NumberForm[#2,** **{3,** **2}],** **10,** **Bold,** **Darker[#3,** **.30]],**
**{#1,** **#2** **+** **.25}**

**]**

**}** **&,**
**{xs,** **means,** **groupColors}**
**],**


**(*** **SSB** ***)**

**{**

**Directive[colorSSB,** **AbsoluteThickness[2.3],** **Arrowheads[.05]],**
**Arrow[{{xA,** **yBar},** **{xA,** **yBar** **+** **sigLen}}]**
**},**
**Text[**
**Style["SSB",** **9,** **Bold,** **colorSSB],**
**{xA** **+** **.24,** **yBar** **+** **sigLen/2},**
**{-1,** **0}**
**],**


**(*** **SSW** ***)**

**{**

**Directive[colorSSW,** **AbsoluteThickness[2.3],** **Arrowheads[.05]],**
**Arrow[{{xA,** **yBar},** **{xA,** **yBar** **-** **noiseLen}}]**
**},**
**Text[**
**Style["SSW",** **9,** **Bold,** **colorSSW],**
**{xA** **+** **.24,** **yBar** **-** **noiseLen/2},**
**{-1,** **0}**
**],**


**(*** **Eticheta** **F** ***)**
**Text[**


_C7 ANOVA.nb_ **19**


**Style["F",** **15,** **Italic,** **Bold,** **GrayLevel[.38]],**
**{xA** **-** **.27,** **yBar}**
**],**


**(*** **Eticheta** **mediei** **globale** ***)**
**Text[**
**Framed[**
**Style[**
**"\!\(\*OverscriptBox[\(y\),** **\(_\)]\)** **=** **"** **<>**
**ToString[NumberForm[yBar,** **{3,** **2}]],**
**9,** **Italic,** **GrayLevel[.20]**
**],**
**Background** **** **White,**
**FrameStyle** **** **GrayLevel[.82],**
**RoundingRadius** **** **3,**
**FrameMargins** **{{5,** **5},** **{3,** **3}}**
**],**
**{8.0,** **yBar},**
**{1,** **0}**

**]**

**},**


**PlotRange** **{{-0.40,** **8.40},** **{yBar** **-** **2.1,** **yBar** **+** **2.1}},**
**Frame** **** **True,**
**FrameTicks** **** **None,**
**FrameStyle** **** **Directive[GrayLevel[.85],** **AbsoluteThickness[1]],**
**ImageSize** **{660,** **240},**
**Background** **** **White,**
**ImagePadding** **{{14,** **18},** **{12,** **12}}**

**]**

**];**


**(*** **========================================** ***)**

**(*** **INTERFATA** ***)**

**(*** **========================================** ***)**


**anovaCompactInterface** **:=** **Manipulate[**
**Module[**

**{**

**means** **=** **{m1,** **m2,** **m3},**
**radii** **=** **{r1,** **r2,** **r3},**
**fVal,**
**fCrit** **=** **3.89**
**},**


**fVal** **=** **Variance[means]/Mean[radii^2** **+** **.01];**


**Column[**

**{**

**Style[**
**"Analiza** **de** **Varianta** **(ANOVA):** **Semnal** **vs.** **Zgomot",**


**20** _C7 ANOVA.nb_


**16,** **Bold**
**],**


**Grid[**

**{**

**{**

**fCompactBox[fVal,** **fCrit],**
**Column[**

**{**

**anovaGraphicCompact[means,** **radii],**
**compactLegend**
**},**
**Alignment** **** **Center,**
**Spacings** **** **0.35**

**]**

**}**

**},**
**Alignment** **** **Center,**
**Spacings** **{1.15,** **0.35}**

**]**

**},**
**Alignment** **** **Center,**
**Spacings** **** **0.75**

**]**

**],**


**Grid[**

**{**

**{**

**Style["Medii** **(efect):",** **10,** **Bold],**
**Control[{{m1,** **0.0,** **"m1"},** **-1.5,** **3.5,** **0.05,** **ImageSize** **** **120}],**
**Control[{{m2,** **1.2,** **"m2"},** **-1.5,** **3.5,** **0.05,** **ImageSize** **** **120}],**
**Control[{{m3,** **2.4,** **"m3"},** **-1.5,** **3.5,** **0.05,** **ImageSize** **** **120}]**
**},**

**{**

**Style["Raze** **(eroare):",** **10,** **Bold],**
**Control[{{r1,** **.3,** **"r1"},** **.1,** **1.2,** **0.02,** **ImageSize** **** **120}],**
**Control[{{r2,** **.3,** **"r2"},** **.1,** **1.2,** **0.02,** **ImageSize** **** **120}],**
**Control[{{r3,** **.3,** **"r3"},** **.1,** **1.2,** **0.02,** **ImageSize** **** **120}]**

**}**

**},**
**Spacings** **{1.4,** **0.9},**
**Alignment** **** **Left**
**],**


**ControlPlacement** **** **Bottom,**
**SaveDefinitions** **** **True,**
**TrackedSymbols** **{m1,** **m2,** **m3,** **r1,** **r2,** **r3}**
**];**


**anovaCompactInterface//Print**


_C7 ANOVA.nb_ **21**


**liza** **de** **Varianta** **(ANOVA):** **Semnal** **vs.** **Zgomot**





m3


r3


**22** _C7 ANOVA.nb_

#### **4. Setarea Problemei: Date și Notație**


Pentru a calcula variabilitatea, avem nevoie de un sistem precis de „etichetare” a datelor.

# ◼ Structura Datelor


Avem k grupuri independente (nivele ale factorului).




- k grupuri

- Observația individuală ( _y_ ij): Reprezintă scorul subiectului _j_ din grupul _i_ .

- Media de grup ( _y_ _i_ ): Media tuturor observațiilor din grupul _i:_



_ni_

 _y_ ij



_y_ _i_ =



1




_ni_ _j_ =1



_j_ =1




- Media globală (y): Media tuturor observațiilor din toate grupurile combinate (Grand
Mean):



_k_ _ni_





_y_ =



1




_N_ _i_ 1



_ni_

 _y_ ij



_i_ =1



_j_ =1


# ◼ Exemplu Didactic: Impactul Pedagogic


 - Ne imaginăm un experiment educațional cu 3 metode de predare ( _k = 3_ )


  - 3 metode de predare: A, B, C

  - **Grupul A** : Predare clasică (tablă și cretă).

  - **Grupul B** : Predare digitală (tablete și simulări).

  - **Grupul C** : Predare prin proiecte (învățare activă).

 - Întrebarea de cercetare:


Influențează metoda de predare **performanța medie** a elevilor sau diferențele observate
sunt doar variații aleatorii între indivizi?


 - Accent:


Este crucial să înțelegem ce “vede” și ce “nu vede” testul ANOVA:


    - **NU comparăm elevi individuali** : Nu ne interesează de ce elevul Popescu a luat

10 și elevul Ionescu a luat 4 în cadrul aceluiași grup (aceasta este “eroarea” sau
zgomotul).

    - **Comparăm performanța sistemelor** : Analizăm dacă metoda în sine (A, B sau C)
deplasează performanța medie a întregului grup într-o direcție semnificativă.

# ◼ Notă


În ANOVA, variația dintre medii este „semnalul” succesului metodei de predare, în timp ce
variația dintre elevii din același grup este “zgomotul” de fundal (diferențe de inteligență,


_C7 ANOVA.nb_ **23**


oboseală, motivație).


**24** _C7 ANOVA.nb_

#### **5. Modelul statistic ANOVA**


Orice valoare observată într-un set de date poate fi descompusă matematic pentru a
înțelege sursa din care provine.


One-Way ANOVA (ANOVA cu un singur factor) modelează observațiile ca


observație = media globală + efectul grupului + eroare observație


iar testul ANOVA verifică dacă efectele grupurilor sunt semnificative comparând variabilitatea între grupuri cu variabilitatea din interiorul grupurilor.

# ◼ Modelul matematic


Ecuația fundamentală a modelului este:


_y_ ij = μ + α _i_ + εij


unde:


   - μ ( **Media Globală / Grand Mean** ): Nivelul de bază al fenomenului studiat, valabil

pentru toată lumea, indiferent de grup.

   - α _i_ (Efectul Grupului i): Cât de mult adaugă sau scade apartenența la un anumit grup
față de media globală.

     - Acesta este Semnalul pe care încercăm să-l detectăm.

     - Dacă α _i_ = 0 pentru toate grupurile, înseamnă că grupurile nu au niciun efect.

   - εij (Eroarea Aleatoare / Reziduurile): Diferența dintre individ și media grupului său.

     - Acesta este Zgomotul. Include toți factorii necontrolați (diferențe genetice, erori de
măsurare, noroc).
### **◻ Interpretare: Ce „construiește” un scor?**


Imaginați-vă scorul unui elev la un test:


   - **Media Globală (μ)** : Cât de greu a fost testul în general pentru toți elevii.

   - **Efectul Grupului (α** _**i**_ **)** : Cât de mult l-a ajutat metoda de predare specifică din clasa lui.

   - **Eroarea (εij)** : Cât de mult a influențat starea lui personală în acea zi (dacă a dormit

bine sau a fost atent).

# ◼ Scopul Testului


ANOVA verifică dacă Efectele Grupurilor (α _i_ ) sunt suficient de mari încât să nu poată fi
explicate doar prin Eroarea Aleatoare (εij).


Dacă grupurile nu au niciun efect, atunci α1 = α2 = … = α _k_ = 0, ceea ce ne conduce direct la
Ipoteza Nulă ( _H_ 0).


_C7 ANOVA.nb_ **25**


**26** _C7 ANOVA.nb_

#### **6. Ipotezele ANOVA: Condiții de Aplicare**


Pentru ca rezultatele testului _F_ să fie valide, datele trebuie să respecte trei criterii fundamentale. În statistici, spunem că ANOVA este un test **parametric** .

# ◼ Ipotezele modelului (condiții de aplicare)


   - 1. **Independența Observațiilor**

     - **Ce** **înseamnă:** Selectarea unui subiect într-un grup nu trebuie să influențeze
selectarea sau scorul altui subiect.

     - **Importanță** : Este cea mai critică ipoteză. Erorile de eșantionare (ex: testarea unor

frați în același grup) pot distorsiona complet rezultatul.

   - 2. **Normalitatea Erorilor**

     - **Ce înseamnă** : În fiecare grup, scorurile (sau reziduurile $\epsilon_{ij}$) trebuie să
urmeze o distribuție Gauss (clopotul lui Gauss).

     - **Verificare** : Se folosesc teste precum **Shapiro-Wilk** sau histograme/grafice Q-Q.

     - **Robustitate** : ANOVA funcționează bine chiar și cu mici abateri, mai ales dacă
eșantioanele sunt mari (n > 30).

   - 3. **Omogenitatea Varianțelor (Omoscedasticitatea)**

     - Ce înseamnă: „Lățimea” cercurilor de variație (zgomotul) trebuie să fie aproximativ

egală în toate grupurile.

     - **Verificare** : Se folosește **Testul Levene** .

     - **De ce contează** : Dacă un grup este mult mai împrăștiat decât celelalte, media sa
devine instabilă, iar testul _F_ își pierde precizia.

# ◼ Remarcă: Robustetea ANOVA


   - ANOVA este considerată o metodă robustă, adică poate tolera încălcări minore ale
normalității sau omogenității, cu o singură condiție majoră:

Grupurile să aibă dimensiuni egale (eșantioane echilibrate).

# ◼ Ce facem dacă ipotezele pică?


Dacă datele sunt distribuite haotic sau varianțele sunt mult prea diferite:


   - Aplicăm o **transformare logaritmică** a datelor.

   - Folosim alternativa neparametrică: **Testul Kruskal-Wallis** .


_C7 ANOVA.nb_ **27**

#### **7. Ipotezele Statistice: Verdictul ANOVA**


Orice test statistic începe cu o stare de “nevinovăție” a datelor, pe care încercăm să o
contestăm prin dovezi (datele colectate).

# ◼ Formularea Formală


   - **Ipoteza Nulă (** _**H**_ **0): „Liniște totală”**

_H_ 0 : μ1 = μ2 =. .. = μ _k_

     - **Traducere** : Toate mediile populațiilor sunt egale. Orice diferență observată în
eșantioane este pur accidentală (zgomot de eșantionare).

   - **Ipoteza Alternativă (** _**H**_ **1): „Există un efect”**

_H_ 1 : ∃ _i_ ≠ _j_ cu μ _i_ ≠μ _j_ (cel puțin două medii diferă)

     - Traducere: Cel puțin două medii sunt semnificativ diferite. Factorul analizat (ex:
metoda de predare) produce o schimbare reală.

# ◼ Interpretarea Corectă: Capcana ANOVA


Este vital să înțelegem ce ne spune și ce nu ne spune un rezultat semnificativ (atunci când
p < 0.05):


**1.** **ANOVA este un test „Omnibus”** : Ea ne dă o alarmă generală. Ne spune: „Ceva se

întâmplă în aceste date, mediile nu sunt toate la fel”.


**2.** **Lipsa localizării** : Respingerea lui _H_ 0 **NU** ne indică:

   - Dacă Grupul 1 diferă de Grupul 2.

   - Dacă doar Grupul 3 este cel “special”.

   - Dacă toate grupurile diferă între ele.

**Analogia radarului** : ANOVA este ca un radar care detectează că există un obiect pe cer,
dar nu îți spune dacă este un avion, o pasăre sau un balon.

# ◼ Ce urmează după H 1?


Dacă am respins _H_ 1, investigația nu se oprește aici. Pentru a „localiza” diferențele, trebuie
să trecem la pasul următor: Comparațiile Multiple (Testele Post-Hoc), cum ar fi testul Tukey
sau Bonferroni.


**28** _C7 ANOVA.nb_

#### **8. Decompunerea Varianței: Mecanismul de Calcul**


Principiul fundamental al ANOVA este **partiționarea variabilității** . Orice abatere a unui
scor individual de la media generală poate fi explicată prin suma a două componente.

# ◼ Identitatea Fundamentală ANOVA

### **◻ Formula**


Variația totală din setul de date se descompune matematic astfel:


SST = SSB + SSW


   - 1. **SST (Sum of Squares Total) — Variația Totală**

     - **Ce este** : Distanța pătratică dintre fiecare observație individuală și Media Globală.



_k_ _ni_




_SST_ = 



_ni_

 _y_ ij - _y_  [2]



_i_ =1



_j_ =1




  - **Semnificație** : Reprezintă **Variabilitatea Brută** (tot ce avem de explicat).

- 2. **SSB (Sum of Squares Between) — Variația ÎNTRE Grupuri**

  - **Ce este** : Distanța dintre media fiecărui grup și Media Globală.



_k_ _ni_

_SSB_ =  _ni_ ( _y_ _i_ - _y_ ) [2]

_i_ =1 _j_ =1




  - **Rol** : Reprezintă **Semnalul** (Varianța Explicată de apartenența la un anumit grup).

  - **Intuție** : Cu cât grupurile sunt mai distanțate între ele, cu atât SSB este mai mare.

- 3. **SSW (Sum of Squares Within) — Variația ÎN INTERIORUL Grupurilor**

  - **Ce este** : Distanța dintre fiecare observație individuală și media grupului din care
face parte.



_k_ _ni_




_SSW_ = 



_ni_

 _y_ ij - _y_ _i_  [2]



_i_ =1



_j_ =1




   - **Rol** : Este variația reziduală (zgomotul sau eroarea).

   - **Intuție** : Reprezintă **Zgomotul** (Varianța Reziduală / Eroarea pe care factorul
studiat nu o poate explica).

În ANOVA, succesul cercetării constă în a demonstra că _SSB_ (Semnalul) este semnificativ
mai mare decât _SSW_ (Zgomotul). Dacă _SSB_ domină, înseamnă că factorul ales de noi
chiar produce o schimbare în realitate.

### **◻ Intuiția Mecanismului**


Dacă vrem să demonstrăm că o metodă de predare funcționează, obiectivul nostru este ca
_SSB_ să ocupe o porțiune cât mai mare din _SST_ .


**Logica ANOVA** : Cu cât mediile grupurilor sunt mai împrăștiate față de centrul general (SSB mare) și cu cât
indivizii sunt mai grupați în jurul propriilor medii (SSW mic), cu atât factorul nostru este mai puternic.


_C7 ANOVA.nb_ **29**

# ◼ Analogia „Puzzle-ului”


Ne imaginăm că scorurile elevilor sunt piese de puzzle împrăștiate pe masă ( _**SST**_ ):


   - Dacă putem grupa piesele după culoarea metodei de predare și obținem grupuri
compacte și separate, am transformat haosul în **Semnal (** _**SSB**_ **)** .

   - Dacă, deși le grupăm, piesele rămân amestecate și împrăștiate în interiorul culorilor,
avem prea mult **Zgomot (** _**SSW**_ **)** .

**Nota bene.** Scopul oricărui cercetător este ca _SSB_ să fie cât mai mare din _SST_, ceea ce ar
însemna că factorul ales de el (tratamentul, metoda) explică cea mai mare parte din
realitate.


**30** _C7 ANOVA.nb_

#### **9. Gradele de Libertate (df)**


Acum trebuie să trecem de la simpla enumerare a formulelor la explicarea rolului lor în
„penalizarea” complexității. În statistica inferențială, nu ne interesează doar cât de mare
este variația, ci cât de multă informație „am consumat” pentru a o calcula.

# ◼ Structura Inferenței


   - **Total** (dftotal = _n_    - 1)

     - Întreaga cantitate de informație disponibilă în eșantion, minus o unitate „pierdută”

pentru calculul mediei globale.

   - **Între grupuri** : (dfbetween = _k_    - 1)

     - Reflectă numărul de grupuri (k). Cu cât avem mai multe grupuri, cu atât avem mai
multe oportunități de a găsi o diferență (dar „costă” grade de libertate).

   - **În interiorul grupurilor** : (dfwithin = _n_    - _k_ )

     - Resursa de informație rămasă pentru a estima eroarea (zgomotul), după ce am
extras influența celor k grupuri.

# ◼ Mesaj Didactic: Prețul Explicației


Gradele de libertate reflectă complexitatea explicației.


Ne gândim la df ca la o **monedă de schimb** :


   - Fiecare grup nou adăugat în studiu ne promite o explicație mai bună a datelor, dar ne
„costă” 1 grad de libertate la numărător ( _dfbetween_ ).

   - Dacă avem prea multe grupuri și prea puțini subiecți, rămânem fără „resurse” ( _dfwithin_ )

pentru a demonstra că rezultatul nu este rodul întâmplării.

Nu putem compara direct Sumele Pătratelor ( _SS_ ), deoarece cele bazate pe mai multe date
vor fi natural mai mari. Folosim gradele de libertate pentru a obține Varianțele Medii ( _MS_ ):



_MS_ =



_SS_


_df_


_C7 ANOVA.nb_ **31**

#### **10. Varianțe medii (Mean Squares)**


Să explicăm de ce nu putem lucra direct cu „Sumele de Pătrate” ( _SS_ ) și de ce avem nevoie
de această medie. Este momentul în care transformăm **cantitatea** de variație într-o **densi-**
**tate** de variație (varianță).

# ◼ Normalizarea variabilității (sumelor de pătrate)


Sumele de pătrate ( _SS_ ) depind de numărul de observații: cu cât avem mai multe date, cu
atât _SS_ crește. Pentru a putea compara „Semnalul” cu „Zgomotul” în mod corect, trebuie să
le raportăm la resursele consumate (gradele de libertate).


Această etapă transformă Sumele (SS) în Varianțe Medii ( _MS_ ):



MSB =



SSB


_k_ - 1



, MSW =



SSW


_n_ - _k_



Interpretarea Componentelor:


2

  - _MSW_ (Mean Square Within) ≈ Varianța Erorii (σε )

   - Este „zgomotul de fond”. Reprezintă media variației naturale din interiorul fiecărui
grup.

   - Este etalonul nostru: ne spune cât de mult se abat datele în mod normal, fără nicio
influență exterioară.

  - _MSB_ (Mean Square Between) ≈ Varianța Factorului

   - Este „semnalul”. Reprezintă variația produsă de apartenența la grupuri diferite.

   - Dacă factorul studiat (ex: metoda de predare) nu are niciun efect, atunci _MSB_ ar

trebui să fie aproximativ egal cu _MSW_ .
### ◻ 💡 De ce este acest pas crucial?


Fără normalizare, un studiu cu 1000 de elevi ar părea să aibă o „eroare” mult mai mare
decât un studiu cu 10 elevi, doar pentru că sumele se adună. Prin împărțirea la gradele de
libertate ( _df_ ), obținem varianța pe unitate de informație, făcând testul _F_ corect și imparțial.


**32** _C7 ANOVA.nb_

#### **11. Statistica F: Testul Propriu-zis**


Acesta este momentul în care comparăm „Semnalul” cu „Zgomotul” pentru a vedea cine
câștigă.

# ◼ Formula Raportului F


Statistica _F_ (numită astfel în onoarea lui Sir Ronald Fisher) se calculează ca raport între
varianța explicată și varianța reziduală:



Varianța **ÎNTRE** (Semnal)


Varianța **ÎN INTERIOR** (Zgomot)



_F_ =



MSB

=
MSW



**Distribuția Teoretică**


 - Sub ipoteza nulă ( _H_ 0), adică atunci când presupunem că grupurile sunt identice,
statistica calculată urmează o distribuție specifică:

_H_ 0 : _F_ ~ _Fk_ -1, _n_                   - _k_

   - df1 = _k_   - 1: Gradele de libertate ale numărătorului (complexitatea modelului).

   - df2 = _n_   - _k_ : Gradele de libertate ale numitorului (resursa pentru eroare).

Tabelul ce urmează indică pentru pragul de semnificație α = 0.05 valorile prag ( _F_ crit): dacă
valoarea _F_ calculată din datele tale este mai mare decât valoarea corespunzătoare din
tabel (identificată prin gradele de libertate df1 și df2, atunci efectul studiat este considerat
semnificativ statistic, iar ipoteza nulă este respinsă.

|df \ df<br>2 1|1|2|3|4|5|
|---|---|---|---|---|---|
|**5**|6.61|5.79|5.41|5.19|5.05|
|**10**|4.96|4.10|3.71|3.48|3.33|
|**15**|4.54|3.68|3.29|3.06|2.90|
|**20**|4.35|3.49|3.10|2.87|2.71|
|**30**|4.17|3.32|2.92|2.69|2.53|
|**60**|4.00|3.15|2.76|2.53|2.37|



Pentru diverse praguri de semnificație α, tabelul poate fi modificat:


_C7 ANOVA.nb_ **33**


**Valori** **Critice** **F:** **Praguri** **0.10** **(sus),** **0.05** **(bold),** **0.01** **(jos)**











|df \ df<br>2 1|1|2|3|4|5|
|---|---|---|---|---|---|
|**5**|4.06<br>**6.61**<br>16.26|3.78<br>**5.79**<br>13.27|3.62<br>**5.41**<br>12.06|3.52<br>**5.19**<br>11.39|3.45<br>**5.05**<br>10.97|
|**10**|3.29<br>**4.96**<br>10.04|2.92<br>**4.10**<br>7.56|2.73<br>**3.71**<br>6.55|2.61<br>**3.48**<br>5.99|2.52<br>**3.33**<br>5.64|
|**15**|3.07<br>**4.54**<br>8.68|2.70<br>**3.68**<br>6.36|2.49<br>**3.29**<br>5.42|2.36<br>**3.06**<br>4.89|2.27<br>**2.90**<br>4.56|
|**20**|2.97<br>**4.35**<br>8.10|2.59<br>**3.49**<br>5.85|2.38<br>**3.10**<br>4.94|2.25<br>**2.87**<br>4.43|2.16<br>**2.71**<br>4.10|
|**30**|2.88<br>**4.17**<br>7.56|2.49<br>**3.32**<br>5.39|2.28<br>**2.92**<br>4.51|2.14<br>**2.69**<br>4.02|2.05<br>**2.53**<br>3.70|
|**60**|2.79<br>**4.00**<br>7.08|2.39<br>**3.15**<br>4.98|2.18<br>**2.76**<br>4.13|2.04<br>**2.53**<br>3.65|1.95<br>**2.37**<br>3.34|


**Intuiția din spatele valorii** _**F**_






 - **Dacă F < 1** : Variabilitatea în interiorul grupurilor este mai mare decât variabilitatea
între grupuri. Diferențele dintre medii sunt complet acoperite de zgomotul natural al
datelor. Nu există niciun indiciu al unui efect sistematic. **Nu putem respinge** _**H**_ **0.**

 - **Dacă F ≈** **1** : Semnalul este aproximativ egal cu zgomotul. Diferențele dintre medii
sunt pur întâmplătoare. **Nu putem respinge** _**H**_ **0.**

 - **Dacă F > 1 (semnificativ)** : Diferențele dintre grupuri sunt mult mai mari decât variația
naturală dintre indivizi. Există indicii că factorul studiat produce un efect. **Decizia**
**formală se ia comparând** 𝐹 **cu** 𝐹 **crit.**

 - **F ≫ 1 ⇒ Diferențe sistematice între grupuri** . Variabilitatea între grupuri domină clar

variabilitatea internă. Apar **diferențe sistematice între grupuri**, sugerând existența
unui efect real al factorului studiat. De regulă, respingem 𝐻0.

Regula formală este:

𝐹 - 𝐹crit ⇒ respingem 𝐻0
𝐹 < 𝐹crit ⇒ nu respingem 𝐻0

unde 𝐹crit depinde de nivelul de semnificație 𝛼 și de gradele de libertate.


ANOVA compară semnalul (diferențele dintre grupuri) cu zgomotul (variabilitatea internă).


Statistica 𝐹 măsoară exact acest raport.


În analiza varianței (ANOVA), decizia statistică se bazează pe valoarea p-value asociată
statisticii 𝐹. Aceasta reprezintă probabilitatea de a observa o valoare a statisticii 𝐹 cel puțin
la fel de mare ca cea obținută experimental, presupunând că ipoteza nulă 𝐻0 este


**34** _C7 ANOVA.nb_


adevărată.


Tabelul de mai jos prezintă valori orientative ale _p_ -value pentru câteva valori tipice ale
statisticii 𝐹 (𝐹 = 2, 3, 4, 5) și pentru diferite grade de libertate ale distribuției 𝐹 (𝑑𝑓1 și 𝑑𝑓2) .
Valorile p mai mici sau egale cu nivelul de semnificație uzual 𝛼 = 0.05 sunt evidențiate cu
bold, indicând situații în care ipoteza nulă ar fi respinsă la acest nivel de semnificație.


**p-value** **pentru** **ANOVA:** **F** **=** **2,** **3,** **4,** **5** **(valorile** **p** **≤** **0.05** **sunt** **cu** **bold)**














|df \ df<br>2 1|1|2|3|4|5|
|---|---|---|---|---|---|
|**5**|F = 2 : 0.216<br>F = 3 : 0.144<br>F = 4 : 0.102<br>F = 5 : 0.076|F = 2 : 0.230<br>F = 3 : 0.139<br>F = 4 : 0.092<br>F = 5 : 0.064|F = 2 : 0.233<br>F = 3 : 0.134<br>F = 4 : 0.085<br>F = 5 : 0.058|F = 2 : 0.233<br>F = 3 : 0.130<br>F = 4 : 0.080<br>F = 5 : 0.054|F = 2 : 0.233<br>F = 3 : 0.127<br>F = 4 : 0.077<br>F = 5 : 0.051|
|**10**|F = 2 : 0.188<br>F = 3 : 0.114<br>F = 4 : 0.073<br>**F = 5 : 0.049**|F = 2 : 0.186<br>F = 3 : 0.095<br>F = 4 : 0.053<br>**F = 5 : 0.031**|F = 2 : 0.178<br>F = 3 : 0.082<br>**F = 4 : 0.041**<br>**F = 5 : 0.023**|F = 2 : 0.171<br>F = 3 : 0.072<br>**F = 4 : 0.034**<br>**F = 5 : 0.018**|F = 2 : 0.164<br>F = 3 : 0.066<br>**F = 4 : 0.030**<br>**F = 5 : 0.015**|
|**15**|F = 2 : 0.178<br>F = 3 : 0.104<br>F = 4 : 0.064<br>**F = 5 : 0.041**|F = 2 : 0.170<br>F = 3 : 0.080<br>**F = 4 : 0.041**<br>**F = 5 : 0.022**|F = 2 : 0.157<br>F = 3 : 0.064<br>**F = 4 : 0.028**<br>**F = 5 : 0.013**|F = 2 : 0.146<br>F = 3 : 0.053<br>**F = 4 : 0.021**<br>**F = 5 : 0.009**|F = 2 : 0.137<br>**F = 3 : 0.045**<br>**F = 4 : 0.017**<br>**F = 5 : 0.007**|
|**20**|F = 2 : 0.173<br>F = 3 : 0.099<br>F = 4 : 0.059<br>**F = 5 : 0.037**|F = 2 : 0.162<br>F = 3 : 0.073<br>**F = 4 : 0.035**<br>**F = 5 : 0.017**|F = 2 : 0.146<br>F = 3 : 0.055<br>**F = 4 : 0.022**<br>**F = 5 : 0.010**|F = 2 : 0.133<br>**F = 3 : 0.043**<br>**F = 4 : 0.015**<br>**F = 5 : 0.006**|F = 2 : 0.123<br>**F = 3 : 0.035**<br>**F = 4 : 0.011**<br>**F = 5 : 0.004**|
|**30**|F = 2 : 0.168<br>F = 3 : 0.094<br>F = 4 : 0.055<br>**F = 5 : 0.033**|F = 2 : 0.153<br>F = 3 : 0.065<br>**F = 4 : 0.029**<br>**F = 5 : 0.013**|F = 2 : 0.135<br>**F = 3 : 0.046**<br>**F = 4 : 0.017**<br>**F = 5 : 0.006**|F = 2 : 0.120<br>**F = 3 : 0.034**<br>**F = 4 : 0.010**<br>**F = 5 : 0.003**|F = 2 : 0.107<br>**F = 3 : 0.026**<br>**F = 4 : 0.007**<br>**F = 5 : 0.002**|
|**60**|F = 2 : 0.162<br>F = 3 : 0.088<br>F = 4 : 0.050<br>**F = 5 : 0.029**|F = 2 : 0.144<br>F = 3 : 0.057<br>**F = 4 : 0.023**<br>**F = 5 : 0.010**|F = 2 : 0.124<br>**F = 3 : 0.037**<br>**F = 4 : 0.012**<br>**F = 5 : 0.004**|F = 2 : 0.106<br>**F = 3 : 0.025**<br>**F = 4 : 0.006**<br>**F = 5 : 0.002**|F = 2 : 0.092<br>**F = 3 : 0.018**<br>**F = 4 : 0.003**<br>**F = 5 : 0.001**|



Pe măsură ce valoarea statisticii 𝐹 crește, probabilitatea 𝑝 scade, indicând o evidență
statistică mai puternică împotriva ipotezei nule.


Putem oferi și un cod în Wolfram care ilustreaza calcularea p-value.


Calculul se bazează pe:


_p_ = _P_ ( _F_ ≥ _F_ calc) = 1 - _F_ CDF( _F_ calc; df1, df2)


_C7 ANOVA.nb_ **35**


Out[23]=

# ◼ Mesaj Central

### **◻ Regula de aur**

|df<br>1|3|
|---|---|
|df2|20|
|Fcalc|4|
|α|0.05|
|p-value|0.0221|
|Decizie|**Respinge H0**|



Statistica _F_ ne spune de câte ori este mai mare variația produsă de factorul nostru (ex:
metoda de predare) față de variația „normală” (eroarea).


Cu cât eșantioanele din interiorul grupurilor sunt mai compacte ( **MSW mic** ) și mediile
grupurilor sunt mai distanțate ( **MSB mare** ), cu atât valoarea _F_ va fi mai mare, indicând un
rezultat clar de **respingere** a ipotezei _H_ 0.


**36** _C7 ANOVA.nb_



**MSB mare**

### **◻ Simulare ANOVA**



**MSW mic**





Codurile ce urmează mai jos ilustrează în mod interactiv modul în care funcționează analiza varianței (ANOVA). Se generează trei grupuri de observații aleatoare, fiecare provenind
din distribuții normale cu aceeași variabilitate internă, dar cu medii diferite. Parametrul _sep_
controlează distanța dintre mediile grupurilor, iar parametrul _sd_ controlează dispersia valorilor din interiorul fiecărui grup.


Pe baza acestor date simulate se calculează componentele clasice ale ANOVA: variația
între grupuri (SSB), variația în interiorul grupurilor (SSW), mediile pătratelor corespunzătoare (MSB și MSW), precum și statistica


_F_ = [MSB]

MSW


Din această statistică se determină p-value, utilizând distribuția _F_ cu gradele de libertate
corespunzătoare.


Vizualizarea arată simultan distribuția observațiilor în cele trei grupuri și rezultatul testului
statistic. Pe măsură ce mediile grupurilor devin mai depărtate (parametrul _sep_ crește) sau


_C7 ANOVA.nb_ **37**


variabilitatea internă scade (parametrul _sd_ scade), statistica F crește, iar p-value devine
mai mică.


Dacă p ≤ α, ipoteza nulă _H_ 0   - conform căreia mediile populațiilor sunt egale – este
respinsă.


Această simulare ne permite să observăm intuitiv relația dintre separarea mediilor, variabilitatea internă și semnificația statistică în cadrul testului ANOVA.


**Notă Metodologică referitor la analiza unifactorilală**


1. **Spațiul Vizual**  [2] : Datele sunt generate cu două coordonate (x, y) pentru a permite o
separare vizuală a grupurilor sub formă de „nori de puncte”. Acest lucru ne ajută să percepem intuitiv conceptul de „grup”.


2. **Reducerea Dimensionalității** : Deși punctele există în plan, ANOVA unifactorială analizează un singur factor. În acest model, variabila dependentă este strict coordonata y.
Liniile fine de proiecție arată cum fiecare punct este „proeictat” pe axa verticală.


3. **Logica ANOVA** : Statistica F măsoară dacă distanța dintre „umbrele” acestor grupuri pe
axa y (Semnalul) este semnificativ mai mare decât împrăștierea punctelor în interiorul
aceluiași grup (Zgomotul). Coordonata x este complet ignorată de calculul statistic, servind
doar ca suport pentru vizualizarea separării.


**38** _C7 ANOVA.nb_


Out[26]=






























|rup|x-Bar|y-Bar|
|---|---|---|
|**G1**|-0.2|-0.0|
|**G2**|1.4|1.9|
|**G3**|3.8|-0.0|


|ndicator|Valoare|
|---|---|
|Statistica F|16.62|
|-value|2.1×10-6<br>|
|Decizie|**RESPINGEM H₀**|



|Col1|Dashboard ANOVA: Semnal vs. Zgomot<br>ANOVA unifactorială compară<br>mediile grupurilor pe o singură dimensiune (y).<br>Distribuția Datelor și Proiecția pe Y<br>y (analizat)<br>4<br>3<br>G2<br>2<br>1<br>G1 G3<br>x (vizual)<br>-1 1 2 3 4 5 6<br>-1<br>Analiza ANOVA (Model Unifactorial)<br>y<br>4<br>3<br>1.9<br>2<br>1<br>-0.0 -0.0<br>0<br>G1 G2 G3<br>-1<br>Grup x-Bar y-Bar Indicator Valoare<br>G1 -0.2 -0.0 Statistica F 16.62<br>G2 1.4 1.9 p-value 2.1×10-6<br>G3 3.8 -0.0 Decizie RESPINGEM H₀<br>Semnal dominant: Mediile pe Y sunt distincte.<br>n Semnal (sep)<br>Zgomot (sd) α 0.1 0.05 0.01|
|---|---|
|||


**Notă Metodologică: Puterea Proiecției și Interpretarea ANOVA Duală**


În practică, fenomenele sunt adesea complexe și multidimensionale. Această simulare
extinsă demonstrează un principiu fundamental în cercetare: **Alegerea variabilei depen-**
**dente determină rezultatul cercetării** .


1. **Aceleași date, două realități statistice** : Observăm cum „norii de puncte” rămân ficși în
spațiul 2D, dar proiecțiile lor pe axele X și Y spun povești diferite. ANOVA pe axa X poate


_C7 ANOVA.nb_ **39**


indica o diferență majoră între grupuri (p-valoare mică), în timp ce ANOVA pe axa Y, aplicată pe aceleași date, poate sugera că grupurile sunt identice.


2. **Sensibilitatea la „Semnal” și „Zgomot”:**


**Pe axa X** (Orizontală): Grupurile G1, G2 și G3 sunt distanțate progresiv. Aici „semnalul”
(distanța dintre medii) este maxim, dominând „zgomotul” (împrăștierea punctelor).


**Pe axa Y** (Verticală): G1 și G3 au medii identice. ANOVA „vede” aici doar o suprapunere
masivă, ignorând faptul că aceste grupuri sunt diferite în realitate (pe cealaltă axă).


3. **Concluzia pentru cercetător** : Simularea ne învață că un rezultat „nesemnificativ” pe o
dimensiune nu înseamnă neapărat că grupurile nu sunt diferite, ci doar că diferența nu se
manifestă pe acea axă specifică. ANOVA unifactorială este un instrument puternic, dar
limitat de „unghiul” din care privim datele.


Out[29]=
















|ANOVA pe X|Col2|Col3|Col4|
|---|---|---|---|
|x1|-0.2|x2|-0.1|
|x3|0.3|Tot|-0.0|
|**F**|3.6|**p**|2.9 × 10-2|
|**Respingem H₀**|**Respingem H₀**|**Respingem H₀**|**Respingem H₀**|


|ANOVA pe Y|Col2|Col3|Col4|
|---|---|---|---|
|y1|-0.1|y2|0.2|
|y3|0.0|Tot|0.1|
|**F**|1.3|**p**|2.9 × 10-1|
|Nu respingem H₀|Nu respingem H₀|Nu respingem H₀|Nu respingem H₀|




**40** _C7 ANOVA.nb_


_C7 ANOVA.nb_ **41**

#### **12. Decizia Statistică: Pragul Semnificației**


Punem accent pe natura „conservatoare” a statisticii: nu respingem ipoteza de egalitate
decât dacă dovezile (semnalul) sunt copleșitoare.


Odată calculat _F_, trebuie să determinăm cât de „rară” este această valoare în ipoteza în
care grupurile ar fi, de fapt, egale.

# ◼ Regula de Decizie


ANOVA este întotdeauna un **test unilateral la dreapta** (ne interesează doar dacă variabilitatea explicată este semnificativ mai mare decât eroarea, nu mai mică).


**Respingem** _**H**_ **0 dacă** : p-value < α (unde α este pragul ales, de obicei 0.05).


**Regiunea Critică** : Este zona din extrema dreaptă a distribuției _F_ . Dacă valoarea noastră
calculată “cade” în această zonă, considerăm efectul ca fiind statistic semnificativ.

### ◻ Densitatea distribuției F

Dacă o variabilă aleatoare F are distribuție F cu d₁ și d₂ grade de libertate, atunci densitatea ei este:





df1+df2


2



_d_ 1
2
_x_







_fF_ ( _x_ ) 



_B_  _[d]_ [1]




[1] _[d]_ [2]

2 [,] 2



1



2 []





valabilă pentru x > 0.


unde :


- _d_ 1 = k - 1 - gradele de libertate ale numărătorului,


- _d_ 2 = n - k - gradele de libertate ale numitorului,


- B(·,·) - funcția Beta.

### Formă echivalentă (folosind funcția Gamma)



_d_ 21 [-][1] 1 +



_d_ 1+ _d_ 2
2



_d_ 1
2
_x_







_d_ 1

_x_
_d_ 2



_fF_ ( _x_ ) 



Γ _[d]_ [1][+] _[d]_ [2] 
2

Γ _[d]_ 2 [1] [Γ] _[d]_ 2 [2] []





Această expresie rezultă din relația dintre funcția Beta și funcția Gamma.

### Interpretare didactică


Distribuția F este o distribuție continuă definită pentru valori pozitive. Ea descrie raportul a


**42** _C7 ANOVA.nb_


două estimări ale varianței scalate prin gradele lor de libertate.

### Legătura cu p-value


p-value reprezintă probabilitatea ca, presupunând ipoteza nulă adevărată, să observăm o
valoare a statisticii F cel puțin la fel de mare ca cea calculată.


∞



pvalue  _P_ ( _F_ d1,d2 ≥ _F_ calc) 
_F_ calc


p-value reprezintă aria din coada dreaptă a distribuției F.



_fF_ ( _x_ )  _x_



Codul ce urmează ilustrează grafic testul _F_, arătând relația dintre _F_ calc, _F_ crit, p-value și
decizia asupra ipotezei nule _H_ 0.



Out[32]=












# ◼ Legătura cu Temele 4-5: Unitate în Inferență

Deși folosim o statistică diferită ( _F_ în loc de _t_ sau _z_ ), **logica inferențială rămâne identică** :


  - **Presupunem** că nu există niciun efect ( _**H**_ 0).

  - **Calculăm** probabilitatea ( _p_ ) de a obține datele noastre sub această presupunere.

  - **Comparăm** această probabilitate cu un prag de siguranță (α).

**Concluzie** : ANOVA nu inventează o logică nouă, ci extinde logica testului _t_ pentru a ges

_C7 ANOVA.nb_ **43**


tiona mai multe grupuri simultan, evitând inflația erorii de tip I.

### **◻ Ce înseamnă p < 0.05 aici?**


Înseamnă că există mai puțin de 5% șanse să fi observat diferențe atât de mari între
metodele de predare dacă ele ar fi fost, în realitate, identice ca eficacitate.


**44** _C7 ANOVA.nb_

#### **13. Tabelul ANOVA**


Tabelul ANOVA (Analysis of Variance) nu este doar o sinteză a calculelor, ci „harta” care
ne permite să navigăm de la date brute la decizii statistice. Toate elementele discutate —
partiționarea varianței, gradele de libertate și normalizarea — converg aici.

# ◼ Anatomia Rezultatului


Acesta este formatul universal pe care îl vei întâlni în software-uri precum SPSS, R, Python
sau Excel. El spune întreaga poveste a datelor dintr-o singură privire.

### **◻ Cum „citim” tabelul (Algoritmul Deciziei)**


**1.** **Coloanele 2 & 3 (SS & df)** : Construiesc materia primă. Aici vedem cum variabilitatea

totală este „tăiată” în felii.


**2.** **Coloana 4 (MS)** : Reprezintă varianțele normalizate. Doar acum putem compara Sem
nalul cu Zgomotul în mod echitabil.


**3.** **Coloana 5 (F)** : Scorul nostru final. Ne spune de câte ori este mai puternic efectul factoru
lui nostru față de eroarea aleatorie.


**4.** **Coloana 6 (p-value)** : Verdictul final. Dacă p < 0.05, respingem Ipoteza Nulă.


_C7 ANOVA.nb_ **45**

### **◻ Implementarea tabelului**






















|Sursă<br>variație|Suma Pătratelor<br>(SS)|df|Media<br>Pătratelor<br>(MS)|F|p-value|
|---|---|---|---|---|---|
|**Între**<br>**grupuri**<br>**(Semnal)**|**SSB**<br>∑_i_=_1_<br>_k_<br>_ni_ (_yi_ -_ y_)_2_|k - 1|**MSB**<br>_SSB_<br>_k_-_1_|**F**<br>_MSB_<br>_MSW_|**p-value**<br>_P_ (_F_(_df1, df2_) ><br>_Fcalc_)|
|În<br>interior<br>(Zgomot)|**SSW**<br>∑_i_=_1_<br>_k_<br>∑_j_=_1_<br>_ni_ (_yij_ -<br>_yi_)_2_|n - k|**MSW**<br>_SSW_<br>_n_-_k_|||
|**Total**|**SST**<br>_SSB_ +_ SSW_|n - 1||||



În practică, acest tabel este generat automat. În Wolfram Mathematica, funcția LinearModelFit transformă datele brute în acest tabel de decizie în mai puțin de o secundă.


**46** _C7 ANOVA.nb_


Out[37]=







Out[39]=


Out[41]=







Există și un pachet specializat ANOVA, care trebuie încărcat mai întâi.


_C7 ANOVA.nb_ **47**












**48** _C7 ANOVA.nb_

#### **14. Interpretarea Rezultatului: Dincolo de p-value**


Odată ce tabelul ANOVA ne oferă valoarea _p_, trebuie să știm ce putere de concluzie avem
și care sunt limitele acesteia.

# ◼ Ce afirmă ANOVA?


Dacă _H_ 0 este respinsă (p < 0.05):


  - Putem afirma cu încredere că **cel puțin două medii sunt diferite între ele** .


  - Există un efect semnificativ statistic al factorului studiat asupra variabilei dependente

# ◼ Ce nu afirmă ANOVA?


  - **Nu indică direcția** : Nu știm care grup este „cel mai bun” sau „cel mai slab”.


  - **Nu indică locația** : Dacă avem 4 grupuri (A, B, C, D), ANOVA nu ne spune dacă A diferă

de B, sau doar C diferă de D.


  - **Nu indică mărimea efectului** : Un _p_ mic nu înseamnă neapărat o diferență uriașă în

realitate, ci doar o diferență care nu e întâmplătoare.

# ◼ Necesitatea Analizelor Post-Hoc (din latină post hoc = „după aceasta”)


Dacă _H_ 0 este respins → trecem la **Testele Post-Hoc** (comparări multiple pentru elementele
perechilor).


   - **Scop** : Identificarea perechilor specifice care diferă (ex: Grup 1 vs 2, 1 vs 3, etc.).

   - **De ce nu teste** _**t**_ **succesive?** Deoarece am acumula eroarea de tip I (am găsi diferențe false).

   - **Soluții standard** : Testul **Tukey HSD** (sincer semnificativ), **Bonferroni** sau **Scheffé** .

# ◼ Legătura cu Regresia Liniară (Viziunea Unificatoare)


ANOVA nu este o insulă izolată, ci un caz particular de Model Liniar General (GLM):


_Y_ = β0 + β1 _X_ + ε


  - În ANOVA, _X_ este o variabilă categorică (metoda de predare).


  - În Regresie, X este o variabilă continuă (orele de studiu).


_C7 ANOVA.nb_ **49**


  - **Identitate** : Statistica _F_ din ANOVA este identică cu statistica _F_ care testează validitatea

modelului de regresie.


**Mesaj de trecere** : Această legătură ne pregătește pentru **Tema următoare**, unde vom
învăța cum să prezicem rezultate folosind modele mai complexe.


ANOVA este semnalul de alarmă; testele Post-Hoc sunt lanterna cu care căutăm detaliile.


**50** _C7 ANOVA.nb_

#### **15. Rezultate de învățare**


La finalul acestei teme, am dobândit instrumentele necesare pentru a trece de la simpla
observare a datelor la decizia statistică riguroasă.


Ce putem face acum?


  - **Identificarea Testului Corect** : Știm să alegem ANOVA atunci când avem o variabilă

dependentă continuă și o variabilă independentă categorică cu mai mult de două niveluri
(dincolo de limitările testului _t_ ).


  - **Formularea Ipotezelor** : Putem traduce o întrebare de cercetare în limbaj statistic ( _H_ 0 vs

_Ha_ ), înțelegând că ANOVA testează egalitatea mediilor prin analiza variabilității.


  - **Interpretarea Tabelului ANOVA** : Nu mai vedem doar cifre, ci înțelegem fluxul logic: de

la Sumele Pătratelor ( _SS_ ), prin normalizarea cu gradele de libertate ( _df_ ), până la raportul
_F_ și probabilitatea _p_ .


  - **Decizia Statistică Avizată** : Știm să interpretăm p-value și să înțelegem când este nece
sară o analiză Post-Hoc pentru a localiza diferențele specifice.


  - **Viziune Unificatoare** : Am înțeles că ANOVA este, de fapt, un caz particular al modelelor

liniare, deschizând drumul către studiul Regresiei.

# ◼ Erori Comune Evitate (Pro-Tip)


**Nu mai confundăm** semnificația statistică ( _p_ ) cu importanța practică (mărimea efectului).


**Nu mai aplicăm** teste _t_ multiple, protejând astfel studiul de inflația erorii de tip I (rezultate
fals-pozitive).

# ◼ Ce urmează?


În tema următoare, vom extinde această „viziune unificatoare” și vom vedea cum putem nu
doar să comparăm grupuri, ci să **prezicem** valori folosind **Regresia Liniară** .


_C7 ANOVA.nb_ **51**

#### **Setări**

# **◼ Setări notebook** **◼ Setări celule**


