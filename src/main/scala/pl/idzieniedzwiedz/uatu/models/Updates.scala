package pl.idzieniedzwiedz.uatu.models

final case class UpdateToDo(
    id: Int,
    todo_id: Option[Int],
    todo_type: Option[String],
  )

