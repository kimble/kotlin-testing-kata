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
            val versionNumberList = str.split(".", "-")
            return VersionNumber(versionNumberList[0].toInt(), versionNumberList[1].toInt(), versionNumberList[2].toInt(), "alpha")
        }

    }


}