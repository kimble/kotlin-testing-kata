package kata



data class VersionNumber(
        val major : Int,
        val minor: Int,
        val patch: Int,
        val preRelease: String? = null,
        val buildInfo: String? = null
) {




    companion object {

        fun from(str : String): VersionNumber {
            return if (str.contains("-")) {
                val versionNumberList = str.split(".")
                val prereleaseList = str.split("-")
                VersionNumber(versionNumberList[0].toInt(), versionNumberList[1].toInt(), versionNumberList[2].toInt(), preRelease = prereleaseList.elementAtOrNull(1))
            } else {
                val versionNumberList = str.split(".", "+")
                VersionNumber(versionNumberList[0].toInt(), versionNumberList[1].toInt(), versionNumberList[2].toInt(), buildInfo = versionNumberList.elementAtOrNull(3))
            }
        }

    }


}
