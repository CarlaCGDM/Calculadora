enum class Especie( //stats base de cada especie de pokemon
    val HP:Int,
    val ataque:Int,
    val defensa:Int,
    val tipo:Tipo,
    val evoluciona:Especie?,
) {
    IVYSAUR(155,151,143, Tipo.PLANTA, null),
    BULBASAUR(128,118,111,Tipo.PLANTA,IVYSAUR),
    CHARMELEON(151,158,126,Tipo.FUEGO,null),
    CHARMANDER(118,116,93,Tipo.FUEGO, CHARMELEON),
    WARTORTLE(153,126,155, Tipo.AGUA,null),
    SQUIRTLE(127,94,121, Tipo.AGUA, WARTORTLE),
    PIKACHU(111,112,96, Tipo.ELECTRICO,null),
    PICHU(85,77,53, Tipo.ELECTRICO,PIKACHU),
    //añadir el resto...
}