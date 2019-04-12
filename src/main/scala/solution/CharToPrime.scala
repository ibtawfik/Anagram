package solution

object CharToPrime {
  //Char.MaxValue is approximately 65000 chars. Here I've only got the first 1000 as it should be sufficient to demonstrate
  //the algorithm
  private val primes: Map[Int, Long] = Map(
    0 -> 2,
    1 -> 3,
    2 -> 5,
    3 -> 7,
    4 -> 11,
    5 -> 13,
    6 -> 17,
    7 -> 19,
    8 -> 23,
    9 -> 29,
    10 -> 31,
    11 -> 37,
    12 -> 41,
    13 -> 43,
    14 -> 47,
    15 -> 53,
    16 -> 59,
    17 -> 61,
    18 -> 67,
    19 -> 71,
    20 -> 73,
    21 -> 79,
    22 -> 83,
    23 -> 89,
    24 -> 97,
    25 -> 101,
    26 -> 103,
    27 -> 107,
    28 -> 109,
    29 -> 113,
    30 -> 127,
    31 -> 131,
    32 -> 137,
    33 -> 139,
    34 -> 149,
    35 -> 151,
    36 -> 157,
    37 -> 163,
    38 -> 167,
    39 -> 173,
    40 -> 179,
    41 -> 181,
    42 -> 191,
    43 -> 193,
    44 -> 197,
    45 -> 199,
    46 -> 211,
    47 -> 223,
    48 -> 227,
    49 -> 229,
    50 -> 233,
    51 -> 239,
    52 -> 241,
    53 -> 251,
    54 -> 257,
    55 -> 263,
    56 -> 269,
    57 -> 271,
    58 -> 277,
    59 -> 281,
    60 -> 283,
    61 -> 293,
    62 -> 307,
    63 -> 311,
    64 -> 313,
    65 -> 317,
    66 -> 331,
    67 -> 337,
    68 -> 347,
    69 -> 349,
    70 -> 353,
    71 -> 359,
    72 -> 367,
    73 -> 373,
    74 -> 379,
    75 -> 383,
    76 -> 389,
    77 -> 397,
    78 -> 401,
    79 -> 409,
    80 -> 419,
    81 -> 421,
    82 -> 431,
    83 -> 433,
    84 -> 439,
    85 -> 443,
    86 -> 449,
    87 -> 457,
    88 -> 461,
    89 -> 463,
    90 -> 467,
    91 -> 479,
    92 -> 487,
    93 -> 491,
    94 -> 499,
    95 -> 503,
    96 -> 509,
    97 -> 521,
    98 -> 523,
    99 -> 541,
    100 -> 547,
    101 -> 557,
    102 -> 563,
    103 -> 569,
    104 -> 571,
    105 -> 577,
    106 -> 587,
    107 -> 593,
    108 -> 599,
    109 -> 601,
    110 -> 607,
    111 -> 613,
    112 -> 617,
    113 -> 619,
    114 -> 631,
    115 -> 641,
    116 -> 643,
    117 -> 647,
    118 -> 653,
    119 -> 659,
    120 -> 661,
    121 -> 673,
    122 -> 677,
    123 -> 683,
    124 -> 691,
    125 -> 701,
    126 -> 709,
    127 -> 719,
    128 -> 727,
    129 -> 733,
    130 -> 739,
    131 -> 743,
    132 -> 751,
    133 -> 757,
    134 -> 761,
    135 -> 769,
    136 -> 773,
    137 -> 787,
    138 -> 797,
    139 -> 809,
    140 -> 811,
    141 -> 821,
    142 -> 823,
    143 -> 827,
    144 -> 829,
    145 -> 839,
    146 -> 853,
    147 -> 857,
    148 -> 859,
    149 -> 863,
    150 -> 877,
    151 -> 881,
    152 -> 883,
    153 -> 887,
    154 -> 907,
    155 -> 911,
    156 -> 919,
    157 -> 929,
    158 -> 937,
    159 -> 941,
    160 -> 947,
    161 -> 953,
    162 -> 967,
    163 -> 971,
    164 -> 977,
    165 -> 983,
    166 -> 991,
    167 -> 997,
    168 -> 1009,
    169 -> 1013,
    170 -> 1019,
    171 -> 1021,
    172 -> 1031,
    173 -> 1033,
    174 -> 1039,
    175 -> 1049,
    176 -> 1051,
    177 -> 1061,
    178 -> 1063,
    179 -> 1069,
    180 -> 1087,
    181 -> 1091,
    182 -> 1093,
    183 -> 1097,
    184 -> 1103,
    185 -> 1109,
    186 -> 1117,
    187 -> 1123,
    188 -> 1129,
    189 -> 1151,
    190 -> 1153,
    191 -> 1163,
    192 -> 1171,
    193 -> 1181,
    194 -> 1187,
    195 -> 1193,
    196 -> 1201,
    197 -> 1213,
    198 -> 1217,
    199 -> 1223,
    200 -> 1229,
    201 -> 1231,
    202 -> 1237,
    203 -> 1249,
    204 -> 1259,
    205 -> 1277,
    206 -> 1279,
    207 -> 1283,
    208 -> 1289,
    209 -> 1291,
    210 -> 1297,
    211 -> 1301,
    212 -> 1303,
    213 -> 1307,
    214 -> 1319,
    215 -> 1321,
    216 -> 1327,
    217 -> 1361,
    218 -> 1367,
    219 -> 1373,
    220 -> 1381,
    221 -> 1399,
    222 -> 1409,
    223 -> 1423,
    224 -> 1427,
    225 -> 1429,
    226 -> 1433,
    227 -> 1439,
    228 -> 1447,
    229 -> 1451,
    230 -> 1453,
    231 -> 1459,
    232 -> 1471,
    233 -> 1481,
    234 -> 1483,
    235 -> 1487,
    236 -> 1489,
    237 -> 1493,
    238 -> 1499,
    239 -> 1511,
    240 -> 1523,
    241 -> 1531,
    242 -> 1543,
    243 -> 1549,
    244 -> 1553,
    245 -> 1559,
    246 -> 1567,
    247 -> 1571,
    248 -> 1579,
    249 -> 1583,
    250 -> 1597,
    251 -> 1601,
    252 -> 1607,
    253 -> 1609,
    254 -> 1613,
    255 -> 1619,
    256 -> 1621,
    257 -> 1627,
    258 -> 1637,
    259 -> 1657,
    260 -> 1663,
    261 -> 1667,
    262 -> 1669,
    263 -> 1693,
    264 -> 1697,
    265 -> 1699,
    266 -> 1709,
    267 -> 1721,
    268 -> 1723,
    269 -> 1733,
    270 -> 1741,
    271 -> 1747,
    272 -> 1753,
    273 -> 1759,
    274 -> 1777,
    275 -> 1783,
    276 -> 1787,
    277 -> 1789,
    278 -> 1801,
    279 -> 1811,
    280 -> 1823,
    281 -> 1831,
    282 -> 1847,
    283 -> 1861,
    284 -> 1867,
    285 -> 1871,
    286 -> 1873,
    287 -> 1877,
    288 -> 1879,
    289 -> 1889,
    290 -> 1901,
    291 -> 1907,
    292 -> 1913,
    293 -> 1931,
    294 -> 1933,
    295 -> 1949,
    296 -> 1951,
    297 -> 1973,
    298 -> 1979,
    299 -> 1987,
    300 -> 1993,
    301 -> 1997,
    302 -> 1999,
    303 -> 2003,
    304 -> 2011,
    305 -> 2017,
    306 -> 2027,
    307 -> 2029,
    308 -> 2039,
    309 -> 2053,
    310 -> 2063,
    311 -> 2069,
    312 -> 2081,
    313 -> 2083,
    314 -> 2087,
    315 -> 2089,
    316 -> 2099,
    317 -> 2111,
    318 -> 2113,
    319 -> 2129,
    320 -> 2131,
    321 -> 2137,
    322 -> 2141,
    323 -> 2143,
    324 -> 2153,
    325 -> 2161,
    326 -> 2179,
    327 -> 2203,
    328 -> 2207,
    329 -> 2213,
    330 -> 2221,
    331 -> 2237,
    332 -> 2239,
    333 -> 2243,
    334 -> 2251,
    335 -> 2267,
    336 -> 2269,
    337 -> 2273,
    338 -> 2281,
    339 -> 2287,
    340 -> 2293,
    341 -> 2297,
    342 -> 2309,
    343 -> 2311,
    344 -> 2333,
    345 -> 2339,
    346 -> 2341,
    347 -> 2347,
    348 -> 2351,
    349 -> 2357,
    350 -> 2371,
    351 -> 2377,
    352 -> 2381,
    353 -> 2383,
    354 -> 2389,
    355 -> 2393,
    356 -> 2399,
    357 -> 2411,
    358 -> 2417,
    359 -> 2423,
    360 -> 2437,
    361 -> 2441,
    362 -> 2447,
    363 -> 2459,
    364 -> 2467,
    365 -> 2473,
    366 -> 2477,
    367 -> 2503,
    368 -> 2521,
    369 -> 2531,
    370 -> 2539,
    371 -> 2543,
    372 -> 2549,
    373 -> 2551,
    374 -> 2557,
    375 -> 2579,
    376 -> 2591,
    377 -> 2593,
    378 -> 2609,
    379 -> 2617,
    380 -> 2621,
    381 -> 2633,
    382 -> 2647,
    383 -> 2657,
    384 -> 2659,
    385 -> 2663,
    386 -> 2671,
    387 -> 2677,
    388 -> 2683,
    389 -> 2687,
    390 -> 2689,
    391 -> 2693,
    392 -> 2699,
    393 -> 2707,
    394 -> 2711,
    395 -> 2713,
    396 -> 2719,
    397 -> 2729,
    398 -> 2731,
    399 -> 2741,
    400 -> 2749,
    401 -> 2753,
    402 -> 2767,
    403 -> 2777,
    404 -> 2789,
    405 -> 2791,
    406 -> 2797,
    407 -> 2801,
    408 -> 2803,
    409 -> 2819,
    410 -> 2833,
    411 -> 2837,
    412 -> 2843,
    413 -> 2851,
    414 -> 2857,
    415 -> 2861,
    416 -> 2879,
    417 -> 2887,
    418 -> 2897,
    419 -> 2903,
    420 -> 2909,
    421 -> 2917,
    422 -> 2927,
    423 -> 2939,
    424 -> 2953,
    425 -> 2957,
    426 -> 2963,
    427 -> 2969,
    428 -> 2971,
    429 -> 2999,
    430 -> 3001,
    431 -> 3011,
    432 -> 3019,
    433 -> 3023,
    434 -> 3037,
    435 -> 3041,
    436 -> 3049,
    437 -> 3061,
    438 -> 3067,
    439 -> 3079,
    440 -> 3083,
    441 -> 3089,
    442 -> 3109,
    443 -> 3119,
    444 -> 3121,
    445 -> 3137,
    446 -> 3163,
    447 -> 3167,
    448 -> 3169,
    449 -> 3181,
    450 -> 3187,
    451 -> 3191,
    452 -> 3203,
    453 -> 3209,
    454 -> 3217,
    455 -> 3221,
    456 -> 3229,
    457 -> 3251,
    458 -> 3253,
    459 -> 3257,
    460 -> 3259,
    461 -> 3271,
    462 -> 3299,
    463 -> 3301,
    464 -> 3307,
    465 -> 3313,
    466 -> 3319,
    467 -> 3323,
    468 -> 3329,
    469 -> 3331,
    470 -> 3343,
    471 -> 3347,
    472 -> 3359,
    473 -> 3361,
    474 -> 3371,
    475 -> 3373,
    476 -> 3389,
    477 -> 3391,
    478 -> 3407,
    479 -> 3413,
    480 -> 3433,
    481 -> 3449,
    482 -> 3457,
    483 -> 3461,
    484 -> 3463,
    485 -> 3467,
    486 -> 3469,
    487 -> 3491,
    488 -> 3499,
    489 -> 3511,
    490 -> 3517,
    491 -> 3527,
    492 -> 3529,
    493 -> 3533,
    494 -> 3539,
    495 -> 3541,
    496 -> 3547,
    497 -> 3557,
    498 -> 3559,
    499 -> 3571,
    500 -> 3581,
    501 -> 3583,
    502 -> 3593,
    503 -> 3607,
    504 -> 3613,
    505 -> 3617,
    506 -> 3623,
    507 -> 3631,
    508 -> 3637,
    509 -> 3643,
    510 -> 3659,
    511 -> 3671,
    512 -> 3673,
    513 -> 3677,
    514 -> 3691,
    515 -> 3697,
    516 -> 3701,
    517 -> 3709,
    518 -> 3719,
    519 -> 3727,
    520 -> 3733,
    521 -> 3739,
    522 -> 3761,
    523 -> 3767,
    524 -> 3769,
    525 -> 3779,
    526 -> 3793,
    527 -> 3797,
    528 -> 3803,
    529 -> 3821,
    530 -> 3823,
    531 -> 3833,
    532 -> 3847,
    533 -> 3851,
    534 -> 3853,
    535 -> 3863,
    536 -> 3877,
    537 -> 3881,
    538 -> 3889,
    539 -> 3907,
    540 -> 3911,
    541 -> 3917,
    542 -> 3919,
    543 -> 3923,
    544 -> 3929,
    545 -> 3931,
    546 -> 3943,
    547 -> 3947,
    548 -> 3967,
    549 -> 3989,
    550 -> 4001,
    551 -> 4003,
    552 -> 4007,
    553 -> 4013,
    554 -> 4019,
    555 -> 4021,
    556 -> 4027,
    557 -> 4049,
    558 -> 4051,
    559 -> 4057,
    560 -> 4073,
    561 -> 4079,
    562 -> 4091,
    563 -> 4093,
    564 -> 4099,
    565 -> 4111,
    566 -> 4127,
    567 -> 4129,
    568 -> 4133,
    569 -> 4139,
    570 -> 4153,
    571 -> 4157,
    572 -> 4159,
    573 -> 4177,
    574 -> 4201,
    575 -> 4211,
    576 -> 4217,
    577 -> 4219,
    578 -> 4229,
    579 -> 4231,
    580 -> 4241,
    581 -> 4243,
    582 -> 4253,
    583 -> 4259,
    584 -> 4261,
    585 -> 4271,
    586 -> 4273,
    587 -> 4283,
    588 -> 4289,
    589 -> 4297,
    590 -> 4327,
    591 -> 4337,
    592 -> 4339,
    593 -> 4349,
    594 -> 4357,
    595 -> 4363,
    596 -> 4373,
    597 -> 4391,
    598 -> 4397,
    599 -> 4409,
    600 -> 4421,
    601 -> 4423,
    602 -> 4441,
    603 -> 4447,
    604 -> 4451,
    605 -> 4457,
    606 -> 4463,
    607 -> 4481,
    608 -> 4483,
    609 -> 4493,
    610 -> 4507,
    611 -> 4513,
    612 -> 4517,
    613 -> 4519,
    614 -> 4523,
    615 -> 4547,
    616 -> 4549,
    617 -> 4561,
    618 -> 4567,
    619 -> 4583,
    620 -> 4591,
    621 -> 4597,
    622 -> 4603,
    623 -> 4621,
    624 -> 4637,
    625 -> 4639,
    626 -> 4643,
    627 -> 4649,
    628 -> 4651,
    629 -> 4657,
    630 -> 4663,
    631 -> 4673,
    632 -> 4679,
    633 -> 4691,
    634 -> 4703,
    635 -> 4721,
    636 -> 4723,
    637 -> 4729,
    638 -> 4733,
    639 -> 4751,
    640 -> 4759,
    641 -> 4783,
    642 -> 4787,
    643 -> 4789,
    644 -> 4793,
    645 -> 4799,
    646 -> 4801,
    647 -> 4813,
    648 -> 4817,
    649 -> 4831,
    650 -> 4861,
    651 -> 4871,
    652 -> 4877,
    653 -> 4889,
    654 -> 4903,
    655 -> 4909,
    656 -> 4919,
    657 -> 4931,
    658 -> 4933,
    659 -> 4937,
    660 -> 4943,
    661 -> 4951,
    662 -> 4957,
    663 -> 4967,
    664 -> 4969,
    665 -> 4973,
    666 -> 4987,
    667 -> 4993,
    668 -> 4999,
    669 -> 5003,
    670 -> 5009,
    671 -> 5011,
    672 -> 5021,
    673 -> 5023,
    674 -> 5039,
    675 -> 5051,
    676 -> 5059,
    677 -> 5077,
    678 -> 5081,
    679 -> 5087,
    680 -> 5099,
    681 -> 5101,
    682 -> 5107,
    683 -> 5113,
    684 -> 5119,
    685 -> 5147,
    686 -> 5153,
    687 -> 5167,
    688 -> 5171,
    689 -> 5179,
    690 -> 5189,
    691 -> 5197,
    692 -> 5209,
    693 -> 5227,
    694 -> 5231,
    695 -> 5233,
    696 -> 5237,
    697 -> 5261,
    698 -> 5273,
    699 -> 5279,
    700 -> 5281,
    701 -> 5297,
    702 -> 5303,
    703 -> 5309,
    704 -> 5323,
    705 -> 5333,
    706 -> 5347,
    707 -> 5351,
    708 -> 5381,
    709 -> 5387,
    710 -> 5393,
    711 -> 5399,
    712 -> 5407,
    713 -> 5413,
    714 -> 5417,
    715 -> 5419,
    716 -> 5431,
    717 -> 5437,
    718 -> 5441,
    719 -> 5443,
    720 -> 5449,
    721 -> 5471,
    722 -> 5477,
    723 -> 5479,
    724 -> 5483,
    725 -> 5501,
    726 -> 5503,
    727 -> 5507,
    728 -> 5519,
    729 -> 5521,
    730 -> 5527,
    731 -> 5531,
    732 -> 5557,
    733 -> 5563,
    734 -> 5569,
    735 -> 5573,
    736 -> 5581,
    737 -> 5591,
    738 -> 5623,
    739 -> 5639,
    740 -> 5641,
    741 -> 5647,
    742 -> 5651,
    743 -> 5653,
    744 -> 5657,
    745 -> 5659,
    746 -> 5669,
    747 -> 5683,
    748 -> 5689,
    749 -> 5693,
    750 -> 5701,
    751 -> 5711,
    752 -> 5717,
    753 -> 5737,
    754 -> 5741,
    755 -> 5743,
    756 -> 5749,
    757 -> 5779,
    758 -> 5783,
    759 -> 5791,
    760 -> 5801,
    761 -> 5807,
    762 -> 5813,
    763 -> 5821,
    764 -> 5827,
    765 -> 5839,
    766 -> 5843,
    767 -> 5849,
    768 -> 5851,
    769 -> 5857,
    770 -> 5861,
    771 -> 5867,
    772 -> 5869,
    773 -> 5879,
    774 -> 5881,
    775 -> 5897,
    776 -> 5903,
    777 -> 5923,
    778 -> 5927,
    779 -> 5939,
    780 -> 5953,
    781 -> 5981,
    782 -> 5987,
    783 -> 6007,
    784 -> 6011,
    785 -> 6029,
    786 -> 6037,
    787 -> 6043,
    788 -> 6047,
    789 -> 6053,
    790 -> 6067,
    791 -> 6073,
    792 -> 6079,
    793 -> 6089,
    794 -> 6091,
    795 -> 6101,
    796 -> 6113,
    797 -> 6121,
    798 -> 6131,
    799 -> 6133,
    800 -> 6143,
    801 -> 6151,
    802 -> 6163,
    803 -> 6173,
    804 -> 6197,
    805 -> 6199,
    806 -> 6203,
    807 -> 6211,
    808 -> 6217,
    809 -> 6221,
    810 -> 6229,
    811 -> 6247,
    812 -> 6257,
    813 -> 6263,
    814 -> 6269,
    815 -> 6271,
    816 -> 6277,
    817 -> 6287,
    818 -> 6299,
    819 -> 6301,
    820 -> 6311,
    821 -> 6317,
    822 -> 6323,
    823 -> 6329,
    824 -> 6337,
    825 -> 6343,
    826 -> 6353,
    827 -> 6359,
    828 -> 6361,
    829 -> 6367,
    830 -> 6373,
    831 -> 6379,
    832 -> 6389,
    833 -> 6397,
    834 -> 6421,
    835 -> 6427,
    836 -> 6449,
    837 -> 6451,
    838 -> 6469,
    839 -> 6473,
    840 -> 6481,
    841 -> 6491,
    842 -> 6521,
    843 -> 6529,
    844 -> 6547,
    845 -> 6551,
    846 -> 6553,
    847 -> 6563,
    848 -> 6569,
    849 -> 6571,
    850 -> 6577,
    851 -> 6581,
    852 -> 6599,
    853 -> 6607,
    854 -> 6619,
    855 -> 6637,
    856 -> 6653,
    857 -> 6659,
    858 -> 6661,
    859 -> 6673,
    860 -> 6679,
    861 -> 6689,
    862 -> 6691,
    863 -> 6701,
    864 -> 6703,
    865 -> 6709,
    866 -> 6719,
    867 -> 6733,
    868 -> 6737,
    869 -> 6761,
    870 -> 6763,
    871 -> 6779,
    872 -> 6781,
    873 -> 6791,
    874 -> 6793,
    875 -> 6803,
    876 -> 6823,
    877 -> 6827,
    878 -> 6829,
    879 -> 6833,
    880 -> 6841,
    881 -> 6857,
    882 -> 6863,
    883 -> 6869,
    884 -> 6871,
    885 -> 6883,
    886 -> 6899,
    887 -> 6907,
    888 -> 6911,
    889 -> 6917,
    890 -> 6947,
    891 -> 6949,
    892 -> 6959,
    893 -> 6961,
    894 -> 6967,
    895 -> 6971,
    896 -> 6977,
    897 -> 6983,
    898 -> 6991,
    899 -> 6997,
    900 -> 7001,
    901 -> 7013,
    902 -> 7019,
    903 -> 7027,
    904 -> 7039,
    905 -> 7043,
    906 -> 7057,
    907 -> 7069,
    908 -> 7079,
    909 -> 7103,
    910 -> 7109,
    911 -> 7121,
    912 -> 7127,
    913 -> 7129,
    914 -> 7151,
    915 -> 7159,
    916 -> 7177,
    917 -> 7187,
    918 -> 7193,
    919 -> 7207,
    920 -> 7211,
    921 -> 7213,
    922 -> 7219,
    923 -> 7229,
    924 -> 7237,
    925 -> 7243,
    926 -> 7247,
    927 -> 7253,
    928 -> 7283,
    929 -> 7297,
    930 -> 7307,
    931 -> 7309,
    932 -> 7321,
    933 -> 7331,
    934 -> 7333,
    935 -> 7349,
    936 -> 7351,
    937 -> 7369,
    938 -> 7393,
    939 -> 7411,
    940 -> 7417,
    941 -> 7433,
    942 -> 7451,
    943 -> 7457,
    944 -> 7459,
    945 -> 7477,
    946 -> 7481,
    947 -> 7487,
    948 -> 7489,
    949 -> 7499,
    950 -> 7507,
    951 -> 7517,
    952 -> 7523,
    953 -> 7529,
    954 -> 7537,
    955 -> 7541,
    956 -> 7547,
    957 -> 7549,
    958 -> 7559,
    959 -> 7561,
    960 -> 7573,
    961 -> 7577,
    962 -> 7583,
    963 -> 7589,
    964 -> 7591,
    965 -> 7603,
    966 -> 7607,
    967 -> 7621,
    968 -> 7639,
    969 -> 7643,
    970 -> 7649,
    971 -> 7669,
    972 -> 7673,
    973 -> 7681,
    974 -> 7687,
    975 -> 7691,
    976 -> 7699,
    977 -> 7703,
    978 -> 7717,
    979 -> 7723,
    980 -> 7727,
    981 -> 7741,
    982 -> 7753,
    983 -> 7757,
    984 -> 7759,
    985 -> 7789,
    986 -> 7793,
    987 -> 7817,
    988 -> 7823,
    989 -> 7829,
    990 -> 7841,
    991 -> 7853,
    992 -> 7867,
    993 -> 7873,
    994 -> 7877,
    995 -> 7879,
    996 -> 7883,
    997 -> 7901,
    998 -> 7907,
    999 -> 7919,
    1000 -> 7927
  )

  def apply(c: Char): Long = {
    primes(c)
  }
}