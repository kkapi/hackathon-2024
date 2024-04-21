export function getYandexRouteLink(lat1, lon1, lat2, lon2) {
	return `https://yandex.ru/maps/2/saint-petersburg/?ll=30.316765%2C59.931635&mode=routes&rtext=${lat1}%2C${lon1}~${lat2}%2C${lon2}&rtt=auto&ruri=~&z=15`;
}

export function getDistance(lat1, lon1, lat2, lon2) {
  const R = 6371e3; // Радиус Земли в метрах
    const φ1 = lat1 * Math.PI / 180; // Преобразование широты в радианы
    const φ2 = lat2 * Math.PI / 180;
    const Δφ = (lat2 - lat1) * Math.PI / 180;
    const Δλ = (lon2 - lon1) * Math.PI / 180;

    const a = Math.sin(Δφ / 2) * Math.sin(Δφ / 2) +
              Math.cos(φ1) * Math.cos(φ2) *
              Math.sin(Δλ / 2) * Math.sin(Δλ / 2);
    const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

    const distance = R * c; // Расстояние в метрах

    if (distance < 1000) return `${Math.floor(distance)} м`;
    return (distance / 1000).toFixed(1) + 'км';
}