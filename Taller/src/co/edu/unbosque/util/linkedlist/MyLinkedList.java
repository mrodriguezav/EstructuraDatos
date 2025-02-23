package co.edu.unbosque.util.linkedlist;

public class MyLinkedList<E> {
	protected Node<E> first; // Si una lista enlazada no tiene cabeza la lista no existe

	public MyLinkedList() {
		this.first = null;
	}
	public Node<E> getFirst() {
		return first;
	}

	public void setFirst(Node<E> first) {
		this.first = first;
	}

	// funcion de verificacion de contenido
	public boolean isEmpty() {
		return (this.first == null);
	}

	// agregar datos
	public void add(E info) {
		Node<E> newNode = new Node<E>(info);
		newNode.setNext(this.first);
		first = newNode;
	}

	// insertar un nodo en una posicion especifica
	public void insert(E info, Node<E> previous) {
		if (previous != null) {
			Node<E> newNode = new Node<E>(info);
			newNode.setNext(previous.getNext());
			previous.setNext(newNode);
		}
	}

	// Agregar al final
	public void addLast(E info) {

		Node<E> lastNode = getLastNode();
		if (lastNode != null) {

			insert(info, lastNode);

		}

		else
			this.first = new Node<E>(info);

	}

	// Obteniendo el ultmo nodo
	public Node<E> getLastNode() {

		Node<E> current = this.first;
		while (current != null && current.getNext() != null) {

			current = current.getNext();
		}
		return current;

	}

	// Extraer el primero

	public E extract() {

		E data = null;

		if (this.first != null) {

			data = this.first.getInfo();
			this.first = (this.first.getNext());

		}

		return data;

	}

	// extraer de cualquier posicion
	public E extract(Node<E> previous) {
		E data = null;

		if (previous != null && previous.getNext() != null) {
			data = previous.getNext().getInfo();
			previous.setNext(previous.getNext().getNext());
		}

		return data;

	}

	// cuantos nodos tengo
	public int size() {

		int size = 0;
		Node<E> current = this.first;

		while (current != null) {
			size++;
			current = current.getNext();
		}

		return size;

	}

	public String print() {

		return this.toString();

	}

	// funcion para obtener un dato sin eliminarlo ---- get
	public Node<E> get(E info) {

		Node<E> targetNode = null;
		Node<E> currentNode = this.first;

		while (currentNode != null && !currentNode.getInfo().equals(info)) {
			currentNode = currentNode.getNext();
		}

		if (currentNode != null) {

			targetNode = currentNode;

		}

		return targetNode;

	}

	public Node<E> get(int n) {

		Node<E> targetNode = null;
		Node<E> currentNode = this.first;

		int counter = 0;

		while (currentNode != null && counter < n) {

			currentNode = currentNode.getNext();
			counter++;

		}

		if (currentNode != null) {
			targetNode = currentNode;
		}

		return targetNode;

	}

	public int indexOf(E info) {

		Node<E> current = this.first;

		int infoPosition = -1;

		if (!isEmpty()) {

			infoPosition = 0;

			while (current != null && !current.getInfo().equals(info)) {
				infoPosition++;

				current = current.getNext();

			}

		}
		return infoPosition;

	}

	public int numberOfOcurrences(E info) {

		Node<E> current = this.first;

		int conta = 0;

		while (current != null) {

			if (current.getInfo().equals(info)) {
				conta++;
			}

			current = current.getNext();

		}

		return conta;
	}

	public E extractList() {

		Node<E> current = this.first;
		E info = null;

		int listSize = size();

		if (!isEmpty()) {

			if (listSize == 1) {
				info = current.getInfo();
				this.first = null;
			} else {

				Node<E> previousLasNode = get(listSize - 2);

				info = extract(previousLasNode);

			}

		}

		return info;

	}

	// Funcion para que imprima los datos y se vea como lista

	public String printList(int index) {

		StringBuilder sv = new StringBuilder();

		Node<E> current = this.first;

		int counter = 0;

		if (!isEmpty()) {
			while (current != null && counter < index) {
				current = current.getNext();
				counter++;
			}

			while (current != null) {
				sv.append(current.getInfo().toString());
				if (current.getNext() != null) {
					sv.append(" -> ");
				}
				current = current.getNext();
			}
		}

		return sv.toString();

	}

	@Override
	public String toString() {

		String listText = "";
		Node<E> current = this.first;

		while (current != null) {

			listText = listText + current.getInfo().toString();

			if (current.getNext() != null) {
				listText += " -> ";

			}
			current = current.getNext();
		}

		return listText;
	}

}
