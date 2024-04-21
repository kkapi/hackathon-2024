import DefaultLayout from '@/layouts/DefaultLayout';
import { Direction, columns } from '../components/directions/columns';
import { DataTable } from '@/components/directions/data-table';
import { useEffect, useState } from 'react';
import { $axios } from '@/http';

async function getData(): Promise<Direction[]> {
	// Fetch data from your API here.
  const { data } = await $axios.get(`/getPoint`);
  console.log(data)
  return data;
}

const UniversitiesPage = () => {
	const [data, setData] = useState<Direction[]>([] as Direction[]);

	useEffect(() => {
		const fetchData = async () => {
			const data1 = await getData();
			setData(data1);
		};
		fetchData();
	}, []);

	return (
		<DefaultLayout>
			<div className="container relative min-h-[100vh]">
				<div className="flex flex-col gap-5">
					<h1 className="mt-5 text-2xl font-bold leading-tight tracking-tighter md:text-4xl">
						Поступление
					</h1>
					<p className="md:w-1/2">
						В данном разделе вы можете найти подробную информацию о различных
						областях обучения в разных университетах. Наша таблица содержит
						всевозможную информацю о различных направлениях в вузах.
					</p>
					<p className="md:w-1/2">
						Данные регулярно обновляются, чтобы вы всегда имели доступ к
						актуальной и точной информации. С нашим удобным интерфейсом и
						мощными поисковыми инструментами, найти подходящую программу никогда
						не было так просто.
					</p>
				</div>
				<div className='mt-7'>
					<DataTable columns={columns} data={data} />
				</div>
			</div>
		</DefaultLayout>
	);
};

export default UniversitiesPage;
