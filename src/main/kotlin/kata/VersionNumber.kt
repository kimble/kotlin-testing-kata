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
            return VersionNumber(1,2,3)
        }

    }


}