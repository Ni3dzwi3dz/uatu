package pl.idzieniedzwiedz.uatu.models

import zio.json.{DeriveJsonDecoder, DeriveJsonEncoder, JsonDecoder, JsonEncoder}

// TODO: Implement ToDoType enum
// enum ToDoType(val todoType: String):
//     case Task extends ToDoType("task")
//     case Bill extends ToDoType("bill")
//     case Repair extends ToDoType("repair")
//     case ShoppingList extends ToDoType("shoppingList")

// object ToDoType:
//   given toDoTypeDecoder: JsonDecoder[ToDoType] = DeriveJsonDecoder.gen[ToDoType]
//   given toDoTypeEncoder: JsonEncoder[ToDoType] = DeriveJsonEncoder.gen[ToDoType]

// final case class ToDoRow(
//     id: Int,
//     todo_id: Int,
//     todo_type: String,
//   )

// object ToDoRow:
//   given todoRowDecoder: JsonDecoder[ToDoRow] = DeriveJsonDecoder.gen[ToDoRow]
//   given todoRowEncoder: JsonEncoder[ToDoRow] = DeriveJsonEncoder.gen[ToDoRow]
