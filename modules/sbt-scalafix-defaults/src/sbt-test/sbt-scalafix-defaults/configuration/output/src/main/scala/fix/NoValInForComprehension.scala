object NoValInForComprehension {

  for {
    n <- List(1, 2, 3)
    inc = n + 1
  } yield inc

}
