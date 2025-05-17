let a > int = 1;
let b > int = 1;
let c > int = 0;

if (a) [
    if (b) [
        if (c) [
            show(10);
        ] else [
            show(20);
        ]
    ] else [
        show(30);
    ]
] else [
    show(40);
]