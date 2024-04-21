import DefaultLayout from '@/layouts/DefaultLayout';

const ApartmentsPage = () => {
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
				</div>
			</div>
		</DefaultLayout>
	);
};

export default ApartmentsPage;
