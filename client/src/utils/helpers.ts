export function getYandexRouteLink(lat1, lon1, lat2, lon2) {
  let url = `https://yandex.ru/maps/2/saint-petersburg/?ll=${lon1}%2C${lat1}&mode=routes&rtext=${lon1}%2C${lat1}~${lon2}%2${lat2}&rtt=auto&ruri=~&z=15`
  return url;
}