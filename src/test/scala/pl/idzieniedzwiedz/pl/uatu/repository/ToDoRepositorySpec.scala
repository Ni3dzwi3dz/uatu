package pl.idzieniedzwiedz.pl.uatu.repository

import zio.test.Assertion.*
import zio.test.*

object ToDoRepositorySpec extends ZIOSpecDefault:
  override def spec = suite("ToDoRepositorySpec")(
    test("getAllTodos") {
      assertTrue(true)
    },
  )
