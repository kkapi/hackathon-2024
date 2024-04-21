import BeautifulCard from '@/components/BeautifulCard';
import LandmarkCard from '@/components/LandmarkCard';
import { Badge } from '@/components/ui/badge';
import { Button } from '@/components/ui/button';
import { Card } from '@/components/ui/card';
import { Input } from '@/components/ui/input';
import { Separator } from '@/components/ui/separator';
import { $axios } from '@/http';
import DefaultLayout from '@/layouts/DefaultLayout';
import { useState } from 'react';

function price(money) {
	const amount = parseFloat(money);
	const formatted = new Intl.NumberFormat('ru-RU', {
		style: 'currency',
		currency: 'RUB',
	}).format(amount);

	return <div className="text-center font-medium">{formatted}</div>;
}

const ApartmentsPage = () => {
	const [address, setAddress] = useState('');
	const [info, setInfo] = useState(null);

	return (
		<DefaultLayout>
			<div className="container relative min-h-[100vh]">
				<div className="flex flex-col gap-5">
					<h1 className="mt-5 text-2xl font-bold leading-tight tracking-tighter md:text-4xl">
						Подбор жилья
					</h1>
					<div className="flex flex-col md:flex-row gap-8">
						<p className="md:w-1/2">
							Найдите свое идеальное студенческое жилье, где ты сможешь удобно и
							комфортно жить во время учебы в Санкт-Петербурге. Наша платформа
							предоставляет информацию и удобный поиск студенческого жилья,
							которое соответствует вашим потребностям и бюджету.
						</p>
					</div>
					<div className="flex flex-col md:flex-row gap-5">
						<Input
							className="md:w-[50%]"
							placeholder="Введите интересующий адрес..."
							value={address}
							onChange={e => setAddress(e.target.value)}
						/>
						<Button
							onClick={async () => {
								const { data } = await $axios.get(`/House?address=${address}`);
								console.log(data);
								setAddress('');
								setInfo(data);
							}}
						>
							Получить информацию
						</Button>
					</div>
					<Separator className="my-4" />
					{!info && (
						<h1 className="font-bold text-3xl">
							Введите адрес для получения справочной информации
						</h1>
					)}
					{info && (
						<div className="flex flex-col gap-5">
							<div className='text-lg font-medium'>
								<span className="mr-3">Адрес:</span>
								{info.address}
							</div>
							<div className='text-lg font-medium'>
								<span className="mr-3">Цена ЖКХ:</span>
								{info.price} руб.
							</div>
							<div className='text-lg font-medium'>
								Наличие Wi-Fi:
								{info.haveWiFi ? (
									<Badge className="ml-2">Есть</Badge>
								) : (
									<Badge className="ml-2">Нет</Badge>
								)}
							</div>
							<div className="grid gap-4 md:grid-cols-2 md:gap-8 lg:grid-cols-3">
								{info.beautifulPlace.map(card => {
									if (card.type === 'Красивое Место') {
										return (
											<BeautifulCard
												key={card.id}
												card={card}
												curCords={[info.coordinate[1], info.coordinate[0]]}
											/>
										);
									}
									if (card.type === 'Достопримечательность') {
										return (
											<LandmarkCard
												key={card.id}
												card={card}
												curCords={[info.coordinate[1], info.coordinate[0]]}
											/>
										);
									}
								})}
							</div>

							<Separator className="my-7" />

							<h1 className="font-semibold text-xl">Спорт площадки:</h1>

							<div className="grid gap-4 md:grid-cols-2 md:gap-8 lg:grid-cols-3">
								{info.sport.map(item => (
									<Card className="p-4 flex flex-col gap-3">
										<div>{item.name}</div>
										<div>
											<Badge>{item.categories}</Badge>
										</div>
										<div>{item.address}</div>
									</Card>
								))}
							</div>
						</div>
					)}
				</div>
			</div>
		</DefaultLayout>
	);
};

export default ApartmentsPage;
