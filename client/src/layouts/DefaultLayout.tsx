
type DefaultLayoutProps = {
  children: React.ReactElement;
};

const DefaultLayout = ({children} : DefaultLayoutProps) => {
  return (
    <>
      {children}
    </>
  )
}

export default DefaultLayout