package android.demo.usingcloudinary

object ImageList {

    private val imageList = listOf(
        "asoggetti-1486419-unsplash",
        "aviv-ben-or-1494731-unsplash",
        "casey-horner-1303359-unsplash",
        "david-wirzba-1346150-unsplash",
        "espen-bierud-1414769-unsplash",
        "francis-nie-1668683-unsplash",
        "james-mckellar-1293717-unsplash",
        "john-fowler-1650254-unsplash",
        "jordan-arnold-1513926-unsplash",
        "joshua-sortino-1281249-unsplash",
        "joshua-sortino-1300842-unsplash",
        "krys-amon-1400440-unsplash",
        "matthew-ronder-seid-1262080-unsplash",
        "stephen-walker-1533496-unsplash",
        "v2osk-1523019-unsplash",
        "zetong-li-1297942-unsplash"
    )

    fun getImageList() = imageList

    fun getImageAt(position:Int) : String = imageList[position]

}