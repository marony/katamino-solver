# Katamino-Solver

## 背景

　Katamino(カタミノ)というフランス製の
[おもちゃ(パズル)を買いました](https://twitter.com/_marony/status/1071394840896667649)
。  
　そこで[解いてみた](https://twitter.com/_marony/status/1071439763310137345)のですが
[なかなかうまくいかない](https://twitter.com/_marony/status/1071443169462472704)
。  

　[仕方がない](https://twitter.com/_marony/status/1071453298597617664)
のでカタミノを解くプログラムを作りました。

　Scalaでリスト(その後Streamに変更)で関数型言語っぽく書いてみたのですが、A8問題の時点で10分とかかかるありさま。
仕方がないので今はループで書き直しまして10秒程度になっています。


## 実行結果(ネタバレ注意)

　ひとまずThe Small Slam(6歳以上向け)のA1〜G8まで解けたので解答をのせておきます。  
　自分で解きたい人は見ないでください。

### The Small Slam
```
[info] Running (fork) binbo_kodakusan.Kanamino 
[info] ========== (TheSmallSlam(),Level(A,3)) ==========
[info] 332
[info] 322
[info] 312
[info] 312
[info] 111
[info] Elapsed(ms) : 142
[info] ========== (TheSmallSlam(),Level(A,4)) ==========
[info] 1114
[info] 2114
[info] 2224
[info] 2344
[info] 3333
[info] Elapsed(ms) : 93
[info] ========== (TheSmallSlam(),Level(A,5)) ==========
[info] 11333
[info] 41135
[info] 44135
[info] 42225
[info] 42255
[info] Elapsed(ms) : 246
[info] ========== (TheSmallSlam(),Level(A,6)) ==========
[info] 522444
[info] 552246
[info] 511246
[info] 513336
[info] 113366
[info] Elapsed(ms) : 165
[info] ========== (TheSmallSlam(),Level(A,7)) ==========
[info] 7777444
[info] 2237445
[info] 1233555
[info] 1223365
[info] 1116666
[info] Elapsed(ms) : 9385
[info] ========== (TheSmallSlam(),Level(A,8)) ==========
[info] 77776222
[info] 87446332
[info] 84466632
[info] 84551133
[info] 88555111
[info] Elapsed(ms) : 19969
[info] ========== (TheSmallSlam(),Level(B,3)) ==========
[info] 322
[info] 322
[info] 332
[info] 131
[info] 111
[info] Elapsed(ms) : 1
[info] ========== (TheSmallSlam(),Level(B,4)) ==========
[info] 4222
[info] 4232
[info] 4433
[info] 1433
[info] 1111
[info] Elapsed(ms) : 2
[info] ========== (TheSmallSlam(),Level(B,5)) ==========
[info] 33555
[info] 35544
[info] 33144
[info] 11142
[info] 12222
[info] Elapsed(ms) : 31
[info] ========== (TheSmallSlam(),Level(B,6)) ==========
[info] 663333
[info] 166623
[info] 112225
[info] 142455
[info] 144455
[info] Elapsed(ms) : 8
[info] ========== (TheSmallSlam(),Level(B,7)) ==========
[info] 2444466
[info] 2273466
[info] 2173336
[info] 2177535
[info] 1117555
[info] Elapsed(ms) : 8623
[info] ========== (TheSmallSlam(),Level(B,8)) ==========
[info] 77711222
[info] 77114425
[info] 66188425
[info] 68883445
[info] 66333355
[info] Elapsed(ms) : 12984
[info] ========== (TheSmallSlam(),Level(C,3)) ==========
[info] 222
[info] 332
[info] 312
[info] 311
[info] 311
[info] Elapsed(ms) : 2
[info] ========== (TheSmallSlam(),Level(C,4)) ==========
[info] 1333
[info] 1123
[info] 1223
[info] 1224
[info] 4444
[info] Elapsed(ms) : 11
[info] ========== (TheSmallSlam(),Level(C,5)) ==========
[info] 25555
[info] 25333
[info] 22334
[info] 21114
[info] 11444
[info] Elapsed(ms) : 35
[info] ========== (TheSmallSlam(),Level(C,6)) ==========
[info] 666644
[info] 222644
[info] 112245
[info] 133335
[info] 113555
[info] Elapsed(ms) : 167
[info] ========== (TheSmallSlam(),Level(C,7)) ==========
[info] 7777555
[info] 7444455
[info] 2241666
[info] 2331116
[info] 2233316
[info] Elapsed(ms) : 2932
[info] ========== (TheSmallSlam(),Level(C,8)) ==========
[info] 77766688
[info] 73336618
[info] 73231118
[info] 22244158
[info] 24445555
[info] Elapsed(ms) : 19110
[info] ========== (TheSmallSlam(),Level(D,3)) ==========
[info] 311
[info] 331
[info] 311
[info] 322
[info] 222
[info] Elapsed(ms) : 1
[info] ========== (TheSmallSlam(),Level(D,4)) ==========
[info] 1333
[info] 1334
[info] 1144
[info] 2124
[info] 2224
[info] Elapsed(ms) : 12
[info] ========== (TheSmallSlam(),Level(D,5)) ==========
[info] 44111
[info] 44421
[info] 33321
[info] 35322
[info] 55552
[info] Elapsed(ms) : 37
[info] ========== (TheSmallSlam(),Level(D,6)) ==========
[info] 633222
[info] 663332
[info] 614452
[info] 611455
[info] 114455
[info] Elapsed(ms) : 213
[info] ========== (TheSmallSlam(),Level(D,7)) ==========
[info] 3332666
[info] 3422266
[info] 3421555
[info] 4411575
[info] 4117777
[info] Elapsed(ms) : 9117
[info] ========== (TheSmallSlam(),Level(D,8)) ==========
[info] 52288881
[info] 55228111
[info] 45326671
[info] 45333677
[info] 44436677
[info] Elapsed(ms) : 22887
[info] ========== (TheSmallSlam(),Level(E,3)) ==========
[info] 332
[info] 322
[info] 321
[info] 321
[info] 111
[info] Elapsed(ms) : 1
[info] ========== (TheSmallSlam(),Level(E,4)) ==========
[info] 3222
[info] 3112
[info] 3312
[info] 4311
[info] 4444
[info] Elapsed(ms) : 4
[info] ========== (TheSmallSlam(),Level(E,5)) ==========
[info] 45555
[info] 45333
[info] 44223
[info] 14123
[info] 11122
[info] Elapsed(ms) : 24
[info] ========== (TheSmallSlam(),Level(E,6)) ==========
[info] 665553
[info] 655333
[info] 612324
[info] 612224
[info] 111444
[info] Elapsed(ms) : 23
[info] ========== (TheSmallSlam(),Level(E,7)) ==========
[info] 5551111
[info] 5644177
[info] 5624337
[info] 6624437
[info] 6222337
[info] Elapsed(ms) : 528
[info] ========== (TheSmallSlam(),Level(E,8)) ==========
[info] 38888666
[info] 33358176
[info] 35551176
[info] 45411277
[info] 44422227
[info] Elapsed(ms) : 51750
[info] ========== (TheSmallSlam(),Level(F,3)) ==========
[info] 333
[info] 331
[info] 111
[info] 212
[info] 222
[info] Elapsed(ms) : 2
[info] ========== (TheSmallSlam(),Level(F,4)) ==========
[info] 4441
[info] 4411
[info] 3321
[info] 3221
[info] 3322
[info] Elapsed(ms) : 1
[info] ========== (TheSmallSlam(),Level(F,5)) ==========
[info] 22221
[info] 32111
[info] 33351
[info] 43455
[info] 44455
[info] Elapsed(ms) : 18
[info] ========== (TheSmallSlam(),Level(F,6)) ==========
[info] 333311
[info] 431112
[info] 444222
[info] 545662
[info] 555666
[info] Elapsed(ms) : 794
[info] ========== (TheSmallSlam(),Level(F,7)) ==========
[info] 6665511
[info] 6264551
[info] 2274531
[info] 2774431
[info] 2774333
[info] Elapsed(ms) : 1955
[info] ========== (TheSmallSlam(),Level(F,8)) ==========
[info] 88833311
[info] 88334115
[info] 77664155
[info] 76644425
[info] 77622225
[info] Elapsed(ms) : 489
[info] ========== (TheSmallSlam(),Level(G,3)) ==========
[info] 222
[info] 332
[info] 312
[info] 311
[info] 311
[info] Elapsed(ms) : 2
[info] ========== (TheSmallSlam(),Level(G,4)) ==========
[info] 1333
[info] 1113
[info] 2213
[info] 2224
[info] 4444
[info] Elapsed(ms) : 11
[info] ========== (TheSmallSlam(),Level(G,5)) ==========
[info] 15555
[info] 15444
[info] 11224
[info] 13324
[info] 33322
[info] Elapsed(ms) : 38
[info] ========== (TheSmallSlam(),Level(G,6)) ==========
[info] 532222
[info] 533326
[info] 555316
[info] 444116
[info] 441166
[info] Elapsed(ms) : 98
[info] ========== (TheSmallSlam(),Level(G,7)) ==========
[info] 1333344
[info] 1132247
[info] 6122447
[info] 6125557
[info] 6665577
[info] Elapsed(ms) : 6873
[info] ========== (TheSmallSlam(),Level(G,8)) ==========
[info] 77714444
[info] 72111488
[info] 72135568
[info] 22335668
[info] 23355668
[info] Elapsed(ms) : 47401
```

## The Slam
```
[info] Running (fork) binbo_kodakusan.Kanamino 
[info] ========== (TheSlam(),Level(A,5)) ==========
[info] 15555
[info] 11225
[info] 41122
[info] 44323
[info] 44333
[info] Elapsed(ms) : 763
[info] ========== (TheSlam(),Level(A,6)) ==========
[info] 444555
[info] 434551
[info] 332211
[info] 633221
[info] 666621
[info] Elapsed(ms) : 961
[info] ========== (TheSlam(),Level(A,7)) ==========
[info] 3311555
[info] 7331565
[info] 7431166
[info] 7444266
[info] 7742222
[info] Elapsed(ms) : 1683
[info] ========== (TheSlam(),Level(A,8)) ==========
[info] 44228888
[info] 74428666
[info] 77422656
[info] 77311555
[info] 33331115
[info] Elapsed(ms) : 5533
[info] ========== (TheSlam(),Level(A,9)) ==========
[info] 999988111
[info] 777988821
[info] 767553321
[info] 666455322
[info] 644445332
[info] Elapsed(ms) : 36853
```
