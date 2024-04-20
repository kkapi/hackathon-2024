import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import { RouterProvider, createBrowserRouter } from 'react-router-dom'
import HomePage from './pages/HomePage.tsx'
import NotFoundPage from './pages/NotFoundPage.tsx'
import PlacesPage from './pages/PlacesPage.tsx'
import ActivitiesPage from './pages/ActivitiesPage.tsx'

const router = createBrowserRouter([{
  path: '/',
  element: <HomePage />,
  errorElement: <NotFoundPage />
}, {
  path: '/routes',
  element: <PlacesPage />
}, {
  path: '/activities',
  element: <ActivitiesPage />
}]);

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
