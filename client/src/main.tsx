import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import HomePage from './pages/HomePage.tsx';
import NotFoundPage from './pages/NotFoundPage.tsx';
import PlacesPage from './pages/PlacesPage.tsx';
import ActivitiesPage from './pages/ActivitiesPage.tsx';
import { ThemeProvider } from './components/ThemeProvider.tsx';
import UniversitiesPage from './pages/UniversitiesPage.tsx';
import ApartmentsPage from './pages/ApartmentsPage.tsx';
import AdditionalEducationPage from './pages/AdditionalEducationPage.tsx';

const router = createBrowserRouter([
	{
		path: '/',
		element: <HomePage />,
		errorElement: <NotFoundPage />,
	},
	{
		path: '/places',
		element: <PlacesPage />,
	},
	{
		path: '/universities',
		element: <UniversitiesPage />,
	},
	{
		path: '/activities',
		element: <ActivitiesPage />,
	},
  {
    path: '/apartments',
    element: <ApartmentsPage />
  },
  {
    path: '/education',
    element: <AdditionalEducationPage />
  }
]);

ReactDOM.createRoot(document.getElementById('root')!).render(
	<React.StrictMode>
		<ThemeProvider defaultTheme="dark" storageKey="vite-ui-theme">
			<RouterProvider router={router} />
		</ThemeProvider>
	</React.StrictMode>
);
