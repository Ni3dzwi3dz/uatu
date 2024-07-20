package pl.idzieniedzwiedz.uatu.models

import java.time.LocalDate
import zio.json.{DeriveJsonDecoder, DeriveJsonEncoder, JsonDecoder, JsonEncoder}


//TODO This is one of the ugliest code I have ever written. I need to think how to abstract it more

abstract class ToDoItem[T<:Row]:
  def toRow: T

  


final case class SimpleTask(
    name: String,
    dueDate: LocalDate,
    description: String,
  ) extends ToDoItem:
   
  override def toRow: TaskRow = TaskRow(0, name, dueDate, description)
  
final case class Bill(
    name: String,
    amount: Double,
    dueDate: LocalDate,
  ) extends ToDoItem:
  

  override def toRow: BillRow = BillRow(0, name, amount, dueDate)

final case class ShoppingList(items: List[String])                extends ToDoItem:
  
 
  override def toRow: ShoppingListRow = ShoppingListRow(0, items)

final case class Repair(item: String, whatNeedsToBeFixed: String) extends ToDoItem:
  
  override def toRow: RepairRow = RepairRow(0, item, whatNeedsToBeFixed)




object ToDo:
  //TODO: There must be a way to generate these automatically

  given taskDecoder: JsonDecoder[SimpleTask] = DeriveJsonDecoder.gen[SimpleTask]
  given taskEncoder: JsonEncoder[SimpleTask] = DeriveJsonEncoder.gen[SimpleTask]

  given billDecoder: JsonDecoder[Bill] = DeriveJsonDecoder.gen[Bill]
  given billEncoder: JsonEncoder[Bill] = DeriveJsonEncoder.gen[Bill]

  given shoppingListDecoder: JsonDecoder[ShoppingList] = DeriveJsonDecoder.gen[ShoppingList]
  given shoppingListEncoder: JsonEncoder[ShoppingList] = DeriveJsonEncoder.gen[ShoppingList]


  given repairDecoder: JsonDecoder[Repair] = DeriveJsonDecoder.gen[Repair]
  given repairEncoder: JsonEncoder[Repair] = DeriveJsonEncoder.gen[Repair]

  

  

