package pl.idzieniedzwiedz.uatu.models

import java.time.LocalDate
import zio.json.{DeriveJsonDecoder, DeriveJsonEncoder, JsonDecoder, JsonEncoder}

sealed trait ToDo 
final case class Task(name: String, dueDate: LocalDate, description: String) extends ToDo
final case class Bill(name: String, amount: Double, dueDate: LocalDate) extends ToDo
final case class ShoppingList(items: List[String]) extends ToDo
final case class Repair(item: String, whatNeedsToBeFixed: String) extends ToDo

object ToDo:
    given taskDecoder: JsonDecoder[Task] = DeriveJsonDecoder.gen[Task]
    given taskEncoder: JsonEncoder[Task] = DeriveJsonEncoder.gen[Task]

    given billDecoder: JsonDecoder[Bill] = DeriveJsonDecoder.gen[Bill]
    given billEncoder: JsonEncoder[Bill] = DeriveJsonEncoder.gen[Bill]

    given shoppingListDecoder: JsonDecoder[ShoppingList] = DeriveJsonDecoder.gen[ShoppingList]
    given shoppingListEncoder: JsonEncoder[ShoppingList] = DeriveJsonEncoder.gen[ShoppingList]

    given repairDecoder: JsonDecoder[Repair] = DeriveJsonDecoder.gen[Repair]
    given repairEncoder: JsonEncoder[Repair] = DeriveJsonEncoder.gen[Repair]