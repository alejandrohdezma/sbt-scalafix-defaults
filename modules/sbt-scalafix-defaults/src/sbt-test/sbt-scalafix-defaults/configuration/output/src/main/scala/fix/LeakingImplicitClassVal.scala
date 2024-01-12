object LeakingImplicitClassVal {

  implicit class StringOps(private val str: String) extends AnyVal {

    def doubled: String = str + str

  }

}
