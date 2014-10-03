description 'User can view list of references'

scenario "User can view all the saved references" {
    given 'user visits main page'
    when 'main page is loaded'
    then 'reference list is shown'
}