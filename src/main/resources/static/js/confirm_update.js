
window.addEventListener('DOMContentLoaded', function(){

	const register_subscription_button = document.getElementById("register_subscription_button");
	register_subscription_button.addEventListener("click", confirmUpdate, false);
	
	function confirmUpdate(message) {
		if(confirm(message)) {
			return true;
		} else {
			return false;
		}
}
});