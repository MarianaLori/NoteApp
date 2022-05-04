package br.senac.noteapp.data

//Essa é uma classe de negócio pro nosso lembrete.

/*
* A declaração dos atributos pode ser feita somente no construtor
* Não é obrigatório um corpo para Data Classes
*/
data class Note(var title: String, var desc: String)
