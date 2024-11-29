package com.example.motoapp.models

import com.example.motoapp.R

data class Moto (
    val id: Int,
    val name: String,
    val marca: String,
    val imageRes: Int,
    val descripition: String,
    val isFavorite: Boolean = false
)
val motoList = listOf(
    Moto(
        id = 1,
        name = "Honda CBR 1000RR",
        marca = "Honda",
        imageRes = R.drawable.hondacbr1000rr,
        descripition = "The Honda CBR1000RR is a 998 cc (60.9 cu in) liquid-cooled inline four-cylinder sportbike, introduced by Honda in 2004 as the 7th generation of the CBR series of motorcycles that began with the CBR900RR in 1992."
    ),
    Moto(
        id = 2,
        name = "Kawasaki Ninja ZX-10R",
        marca = "Kawasaki",
        imageRes = R.drawable.kawasakininjazx10r,
        descripition = "The Kawasaki Ninja ZX-10R is a motorcycle in the Ninja sport bike series from the Japanese manufacturer Kawasaki, the successor to the Ninja ZX-9R. It was originally released in 2004 with minor revisions in 2005. It combines an ultra-narrow chassis, low weight, and radial brakes."
    ),
    Moto(
        id = 3,
        name = "Suzuki GSX-R1000",
        marca = "Suzuki",
        imageRes = R.drawable.suzukigsxr1000,
        descripition = "The Suzuki GSX-R1000 is a sport bike from Suzuki's GSX-R series of motorcycles. It was introduced in 2001 to replace the GSX-R1100 and is powered by a liquid-cooled 999 cc (61.0 cu in) inline four-cylinder, four-stroke engine."
    ),
    Moto(
        id = 4,
        name = "Yamaha YZF-R1",
        marca = "Yamaha",
        imageRes = R.drawable.yamahayzfr1,
        descripition = "The Yamaha YZF-R1, or R1, is an open class sport bike, or superbike, motorcycle manufactured by Yamaha Motor Company since 1998."
    ),
    Moto(
        id = 5,
        name = "Honda XRE 300",
        marca = "Honda",
        imageRes = R.drawable.hondaxre300,
        descripition = "The Honda XRE 300 is a dual-sport motorcycle developed by Honda for the South American market. It was launched in 2009 and updated in 2013."
    ),
    Moto(
        id = 6,
        name = "Kawasaki Versys 650",
        marca = "Kawasaki",
        imageRes = R.drawable.kawasakiversys650,
        descripition = "The Kawasaki Versys 650 is a versatile bike that is designed to do it all. It is a sporty bike that is comfortable for long rides and can handle the twisties with ease."
    ),
    Moto(
        id = 7,
        name = "Suzuki V-Strom 650",
        marca = "Suzuki",
        imageRes = R.drawable.suzukivstrom650,
        descripition = "The Suzuki V-Strom 650 is a versatile bike that is designed to do it all. It is a sporty bike that is comfortable for long rides and can handle the twisties with ease."
    ),
    Moto(
        id = 8,
        name = "Yamaha MT-07",
        marca = "Yamaha",
        imageRes = R.drawable.yamahamt07,
        descripition = "The Yamaha MT-07 is a versatile bike that is designed to do it all. It is a sporty bike that is comfortable for long rides and can handle the twisties with ease."
    ),
    Moto(
        id = 9,
        name = "Honda CB 500X",
        marca = "Honda",
        imageRes = R.drawable.hondacb500x,
        descripition = "The Honda CB 500X is a versatile bike that is designed to do it all. It is a sporty bike that is comfortable for long rides and can handle the twisties with ease."
    ),
    Moto(
        id = 10,
        name = "Kawasaki Z400",
        marca = "Kawasaki",
        imageRes = R.drawable.kawasakiz400,
        descripition = "The Kawasaki Z400 is a versatile bike that is designed to do it all. It is a sporty bike that is comfortable for long rides and can handle the twisties with ease."
    ),
)