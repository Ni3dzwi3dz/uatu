package pl.idzieniedzwiedz.uatu.models

import java.time.LocalDate
import zio.json.{DeriveJsonDecoder, DeriveJsonEncoder, JsonDecoder, JsonEncoder}

abstract class Row(val id: Int)


final case class TaskRow(
      override val id: Int,
      name: String,
      dueDate: LocalDate,
      description: String,
    ) extends Row(id):
      def toToDoItem: SimpleTask = SimpleTask(name, dueDate, description)
  
object TaskRow:
    given taskRowDecoder: JsonDecoder[TaskRow] = DeriveJsonDecoder.gen[TaskRow]
    given taskRowEncoder: JsonEncoder[TaskRow] = DeriveJsonEncoder.gen[TaskRow]
final case class BillRow(
      override val id: Int,
      name: String,
      amount: Double,
      dueDate: LocalDate,
    ) extends Row(id):
    def toToDoItem: Bill = Bill(name, amount, dueDate)

object BillRow:
    given taskRowDecoder: JsonDecoder[TaskRow] = DeriveJsonDecoder.gen[TaskRow]
    given taskRowEncoder: JsonEncoder[TaskRow] = DeriveJsonEncoder.gen[TaskRow]

final case class ShoppingListRow(
      override val id: Int,
      items: List[String],
    ) extends Row(id):
  
    def toToDoItem: ShoppingList = ShoppingList(items)

object ShoppingListRow:
    given shoppingListRowDecoder: JsonDecoder[ShoppingListRow] = DeriveJsonDecoder.gen[ShoppingListRow]
    given shoppingListRowEncoder: JsonEncoder[ShoppingListRow] = DeriveJsonEncoder.gen[ShoppingListRow]

final case class RepairRow(
      override val id: Int,
      item: String,
      whatNeedsToBeFixed: String,
    ) extends Row(id):
    def toToDoItem: Repair = Repair(item, whatNeedsToBeFixed)

object RepairRow:
    given repairRowDecoder: JsonDecoder[RepairRow] = DeriveJsonDecoder.gen[RepairRow]
    given repairRowEncoder: JsonEncoder[RepairRow] = DeriveJsonEncoder.gen[RepairRow]

final case class ToDoRow(
    override val id: Int,
    todo_id: Int,
    todo_type: String,
  ) extends Row(id)

object ToDoRow:
    given toDoRowDecoder: JsonDecoder[ToDoRow] = DeriveJsonDecoder.gen[ToDoRow]
    given toDoRowEncoder: JsonEncoder[ToDoRow] = DeriveJsonEncoder.gen[ToDoRow]

