object LeakingImplicitClassVal {

  implicit class StringOps(val str: String) extends AnyVal {
    def doubled: String = str + str
  }

}