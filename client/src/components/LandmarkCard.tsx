import {
	Dialog,
	DialogClose,
	DialogContent,
	DialogDescription,
	DialogFooter,
	DialogHeader,
	DialogTitle,
	DialogTrigger,
} from './ui/dialog';
import {
	Card,
	CardContent,
	CardDescription,
	CardFooter,
	CardHeader,
	CardTitle,
} from './ui/card';
import { Badge } from './ui/badge';
import { MapPin, Navigation } from 'lucide-react';
import { getDistance, getYandexRouteLink } from '@/utils/helpers';
import { Separator } from './ui/separator';
import { Button } from './ui/button';
import { ImageOff } from 'lucide-react';

const LandmarkCard = ({ card, curCords }) => {
	return (
		<Dialog key={card.id}>
			<DialogTrigger asChild>
				<Card className="hover:cursor-pointer hover:border-blue-300 hover:bg-muted transition-colors duration-300 ease-in-out">
					<CardHeader>
						<CardTitle>{card.attractions.name} </CardTitle>
						<CardDescription className="flex gap-2 pt-2">
							<Badge variant="secondary">#{card.category} </Badge>
							{card.wiFi.length > 0 ? (
								<Badge variant="secondary">#Wi-Fi</Badge>
							) : (
								''
							)}
							<Badge>
								<Navigation className="w-4 mr-1" />{' '}
								{getDistance(
									curCords[1],
									curCords[0],
									card.longitude,
									card.latitude
								)}{' '}
								от вас
							</Badge>
						</CardDescription>
					</CardHeader>
					<CardContent className="flex flex-row content-center items-start gap-5 md:flex-col md:items-center">
						<img
							src="/3.png"
							className="object-cover w-1/3 lg:w-2/3 rounded-xl"
						/>
						
						<p>
							{card.attractions.description &&
							card.attractions.description.length > 120
								? `${card.attractions.description.slice(0, 120)}. . .`
								: card.attractions.description}
							{!card.attractions.description &&
								'У данной достопримечательности нет описания.'}
						</p>
					</CardContent>
					<CardFooter className="block">
						<div>
							<p className="text-sm text-muted-foreground">
								Адрес: {card.attractions.addressManual || 'Санкт-Петербург'}
							</p>
						</div>
					</CardFooter>
				</Card>
			</DialogTrigger>
			<DialogContent className="sm:max-w-md overflow-y-auto max-h-[90vh] max-w-[90vw] md:max-w-[50vw]">
				<DialogHeader>
					<DialogTitle className="text-xl">{card.attractions.name}</DialogTitle>
					<DialogDescription className="flex gap-2">
						<Badge variant="secondary">#{card.category}</Badge>

						{card.wiFi.length > 0 ? (
							<Badge variant="secondary">#Wi-Fi</Badge>
						) : (
							''
						)}
					</DialogDescription>
				</DialogHeader>

				<p className="md:px-5">
					{card.attractions.description}
					{!card.attractions.description &&
						'У данной достопримечательности нет описания.'}
				</p>

				<Separator className="mb-4" />

				<div className="flex flex-col gap-3">
					{card.wiFi.length > 0 && (
						<div className="md:px-5">
							<div className="font-bold mb-2"> Ближайшие Wi-Fi точки</div>
							{card.wiFi.slice(0, 6).map((wifi, indx) => (
								<div key={indx}>
									<a
										href={getYandexRouteLink(
											curCords[1],
											curCords[0],
											wifi.lon,
											wifi.lat
										)}
										target="_blank"
										className="text-muted-foreground transition-colors hover:text-foreground flex gap-2 mb-1"
									>
										{wifi.address}
										<MapPin className="w-4" />
										<Badge variant="secondary">
											{getDistance(
												card.longitude,
												card.latitude,
												wifi.lon,
												wifi.lat
											)}
										</Badge>
									</a>
								</div>
							))}
						</div>
					)}

					<div className="md:px-5">
						<div className="font-bold"> Ближайший общественный туалет </div>
						<a
							href={getYandexRouteLink(
								curCords[1],
								curCords[0],
								card.toilets.lon,
								card.toilets.lat
							)}
							target="_blank"
							className="text-muted-foreground transition-colors hover:text-foreground flex gap-2"
						>
							{card.toilets.address}
							<MapPin className="w-4" />
							<Badge variant="secondary">
								{getDistance(
									card.longitude,
									card.latitude,
									card.toilets.lon,
									card.toilets.lat
								)}
							</Badge>
						</a>
					</div>

					<Separator className="my-2" />

					<div className="text-muted-foreground md:px-5">
						<Badge className="mb-2">
							<Navigation className="w-4 mr-1" />{' '}
							{getDistance(
								curCords[1],
								curCords[0],
								card.longitude,
								card.latitude
							)}{' '}
							от вас
						</Badge>
						<p className="mb-2 text-muted-foreground">
							Адрес: {card.attractions.addressManual || 'Санкт-Петербург'}
						</p>
						Станция метро "{card.metro.name}"
					</div>
				</div>
				<DialogFooter>
					<div className="flex flex-col gap-4 md:flex-row">
						<div>
							<a
								href={getYandexRouteLink(
									curCords[1],
									curCords[0],
									card.longitude,
									card.latitude
								)}
								target="_blank"
							>
								<Button className="w-full">Построить маршрут</Button>
							</a>
						</div>
						<div>
							<DialogClose asChild>
								<Button type="button" variant="secondary" className="w-full">
									Закрыть
								</Button>
							</DialogClose>
						</div>
					</div>
				</DialogFooter>
			</DialogContent>
		</Dialog>
	);
};

export default LandmarkCard;
