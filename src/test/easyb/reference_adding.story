description 'User can add new book references to data storage'

scenario "User adds successfully all requested data items", {
    given 'user visits page to add a reference'
    when 'user submits valid data to all the data fields'
    then 'reference will be created and saved to repository'
}

scenario "User can't submit the form if one or more data items is left blank", {
    given 'user visits page to add a reference'
    when 'user doesn't enter valid data to all the data fields'
    then 'reference will not be created or saved to repository'
}