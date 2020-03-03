function saveItem(item) {

	if (JSON.parse(localStorage.getItem(item.id)) === null) {
		item.quantity = 1;
	} else {
		item = JSON.parse(localStorage.getItem(item.id))
		item.quantity = item.quantity + 1;
	}
	
	localStorage.setItem(item.id, JSON.stringify(item));
}