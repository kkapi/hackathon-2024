export function getYandexRouteLink(lat1, lon1, lat2, lon2) {
	return `https://yandex.ru/maps/2/saint-petersburg/?ll=30.316765%2C59.931635&mode=routes&rtext=${lat1}%2C${lon1}~${lat2}%2C${lon2}&rtt=auto&ruri=~&z=15`;
}