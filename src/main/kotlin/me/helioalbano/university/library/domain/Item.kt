package me.helioalbano.university.library.domain

import java.time.LocalDate
import java.util.UUID

sealed class Item(
  open val id: UUID = UUID.randomUUID(),
  open val code: String,
  open val title: String,
  open val acquisitionDate: LocalDate = LocalDate.now()
) {
  data class Book(
    override val id: UUID = UUID.randomUUID(),
    override val code: String,
    override val title: String,
    override val acquisitionDate: LocalDate = LocalDate.now(),
    val author: String,
  ) : Item(id, code, title, acquisitionDate)
  
  data class Magazine(
    override val id: UUID = UUID.randomUUID(),
    override val code: String,
    override val title: String,
    override val acquisitionDate: LocalDate = LocalDate.now(),
    val issueNumber: Int,
  ) : Item(id, code, title, acquisitionDate)
}