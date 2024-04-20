import Balance from 'react-wrap-balancer';

import { cn } from '@/lib/utils';
import { Button } from '@/components/ui/button';
import { Separator } from '@/components/ui/separator';
import { Card, CardContent, CardHeader, CardTitle } from '@/components/ui/card';
import DefaultLayout from '@/layouts/DefaultLayout';
import { useNavigate } from 'react-router-dom';
import { Castle } from 'lucide-react';
import { GraduationCap } from 'lucide-react';
import { CalendarSearch } from 'lucide-react';
import { Home } from 'lucide-react';
import { BookOpenText } from 'lucide-react';

const HomePage = () => {
	const navigate = useNavigate();

	return (
		<DefaultLayout>
			<div className="container relative">
				<section
					className={cn(
						'mx-auto flex max-w-[980px] flex-col items-center gap-2 py-8 md:py-12 md:pb-8 lg:py-24 lg:pb-20'
					)}
				>
					<h1
						className={cn(
							'text-center text-3xl font-bold leading-tight tracking-tighter md:text-6xl lg:leading-[1.1]'
						)}
					>
						Ассистент студента СПб
					</h1>
					<Balance
						className={cn(
							'max-w-[750px] text-center text-lg text-muted-foreground sm:text-xl'
						)}
					>
						Добро пожаловать на цифровой сервис «Ассистент студента СПб»! Мы
						помогаем формировать рекомендации в сфере образования, науки, досуга
						и быта, чтобы помочь вам лучше управлять своим временем и получать
						максимум удовольствия и пользы от студенческой жизни.
					</Balance>
					<div
						className={cn(
							'flex w-full items-center justify-center space-x-4 py-4 md:pb-10'
						)}
					>
						<Button onClick={() => {}}>Начать</Button>
						<Button variant="outline">GitHub</Button>
					</div>
				</section>

				<Separator />

				<div className="mt-12 grid gap-4 md:grid-cols-2 md:gap-8 lg:grid-cols-3">
					<Card
						onClick={() => navigate('/places')}
						className="hover:cursor-pointer hover:border-blue-300 hover:bg-muted"
					>
						<CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
							<CardTitle className="text-xl font-medium">Места рядом</CardTitle>
						</CardHeader>
						<CardContent className="flex items-center justify-center gap-4">
							<p className="text-xs text-muted-foreground w-5/6">
								Узнайте о лучших местах в городе для занятий и работы в удобной
								и красивой обстановке. Мы предоставили список мест, которые
								отличаются не только своей привлекательностью, но и обладают
								такими удобствами, как бесплатные точки доступа Wi-Fi,
								общественные туалеты и ближайшие станции метро.
							</p>
							<Castle className="w-1/6 h-auto" />
						</CardContent>
					</Card>
					<Card
						onClick={() => navigate('/universities')}
						className="hover:cursor-pointer hover:border-blue-300 hover:bg-muted"
					>
						<CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
							<CardTitle className="text-xl font-medium">Поступление</CardTitle>
						</CardHeader>
						<CardContent className="flex items-center justify-center gap-4">
							<p className="text-xs text-muted-foreground w-5/6">
								Исследуйте мир образования! Подберите ВУЗ для поступления по
								проходным баллам, предметам для сдачи, профессиям и другим
								параметрам. Найдите идеальное образовательное направление для
								вашего будущего. Планируйте свое обучение с удобством и
								точностью, открывая двери к успешной карьере.
							</p>
							<GraduationCap className="w-1/6 h-auto" />
						</CardContent>
					</Card>
					<Card
						onClick={() => navigate('/activities')}
						className="hover:cursor-pointer hover:border-blue-300 hover:bg-muted"
					>
						<CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
							<CardTitle className="text-xl font-medium">Мероприятия</CardTitle>
						</CardHeader>
						<CardContent className="flex items-center justify-center gap-4">
							<p className="text-xs text-muted-foreground w-5/6">
								Найдите разнообразные мероприятия, которые помогут развивать
								ваши профессиональные навыки. Наша платформа учитывает близость
								к вашему дому, работе или учебе, а также место проведения
								занятий, чтобы предложить наиболее удобные и полезные
								мероприятия для вас.
							</p>
							<CalendarSearch className="w-1/6 h-auto" />
						</CardContent>
					</Card>
					<Card
						onClick={() => navigate('/apartments')}
						className="hover:cursor-pointer hover:border-blue-300 hover:bg-muted"
					>
						<CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
							<CardTitle className="text-xl font-medium">
								Подбор жилья
							</CardTitle>
						</CardHeader>
						<CardContent className="flex items-center justify-center gap-4">
							<p className="text-xs text-muted-foreground w-5/6">
								Найдите свое идеальное студенческое жилье, где ты сможешь удобно
								и комфортно жить во время учебы в Санкт-Петербурге. Наша
								платформа предоставляет информацию и удобный поиск студенческого
								жилья, которое соответствует вашим потребностям и бюджету.
							</p>
							<Home className="w-1/6 h-auto" />
						</CardContent>
					</Card>
					<Card
						onClick={() => navigate('/education')}
						className="hover:cursor-pointer hover:border-blue-300 hover:bg-muted"
					>
						<CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
							<CardTitle className="text-xl font-medium">
								Подбор программ доп. образования
							</CardTitle>
						</CardHeader>
						<CardContent className="flex items-center justify-center gap-4">
							<p className="text-xs text-muted-foreground w-5/6">
								Ознакомьтесь с программами
								дополнительного образования для студентов. Откройте широкий
								спектр курсов, мастер-классов и возможностей углубленного
								обучения, предназначенных для улучшения академических
								результатов, расширения кругозора и развития личности.
							</p>
							<BookOpenText className="w-1/6 h-auto" />
						</CardContent>
					</Card>
				</div>
			</div>
		</DefaultLayout>
	);
};

export default HomePage;
